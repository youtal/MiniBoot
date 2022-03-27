package com.mrc.miniboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrc.miniboot.entity.users.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class LoginController {

    @Value("${wechat.code2session}")
    private String code2SessionUrl;

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.secret}")
    private String appsecret;

    @Resource
    User user;

    /**
     * code登陆
     */
    @GetMapping("login")
    public String codeLogin(String code) {
        /**
         * code2Session 接口Url 拼接
         * code2Session开发者服务器使用临时登录凭证code获取 session_key、
         * 用户userid以及用户所在企业的corpid等信息。
         * https://work.weixin.qq.com/api/doc/90000/90136/91507
         */
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appid", this.appid);
        requestMap.put("secret", this.appsecret);
        requestMap.put("code", code);
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> responseEntity = rest.getForEntity(this.code2SessionUrl, String.class,requestMap);
        JSONObject jsonObject=JSONObject.parseObject(responseEntity.getBody());
        String openId=jsonObject.getString("openid");


        if (Objects.equals(openId, null))
            return "error! openid not found";

        if (user.hasUser(openId))
            return user.getUserById(openId).getCharacter();
        else return "new user";

    }

}


