package com.mrc.miniboot.utils;

import com.alibaba.fastjson.JSONObject;
import com.mrc.miniboot.entity.OpenIdCache;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static String code2OpenId(String code){
        if (OpenIdCache.contains(code)) {
            return OpenIdCache.get(code);
        }

        String appid = "wx9b07bbb9b447e524";
        String appsecret = "6f31ece9ab57b787ac5359583bebce4b";
        String code2sessionUrl = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type=authorization_code";
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appid", appid);
        requestMap.put("secret", appsecret);
        requestMap.put("code", code);
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> responseEntity = rest.getForEntity(code2sessionUrl, String.class,requestMap);
        JSONObject jsonObject=JSONObject.parseObject(responseEntity.getBody());
        //------
        System.out.println("jsonObject: "+jsonObject);
        //------
        String openId=jsonObject.getString("openid");
        OpenIdCache.add(code,openId);
        return openId;
    }
}

