package com.mrc.miniboot.controller;

import com.mrc.miniboot.entity.users.User;
import com.mrc.miniboot.utils.Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class LoginController {
/*
    @Value("${wechat.code2session}")
    private String code2SessionUrl;

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.secret}")
    private String appsecret;

    @Resource
    User user;*/

    @Resource
    User user;
    /**
     * code登陆
     */
    @GetMapping("login")
    public String codeLogin(String openid) {
        /*
        String openId = Utils.code2OpenId(code);
        if (openId == null)
            return "code error";
        if (user.hasUser(openId)){
            User curUser = user.getUserById(openId);
            curUser.updateUser();
            return curUser.getCharacter();
        }
        return "new user";*/
        System.out.println(openid);
        return "login";
    }

}


