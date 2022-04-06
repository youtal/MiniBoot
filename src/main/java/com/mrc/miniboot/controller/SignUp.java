package com.mrc.miniboot.controller;

import com.mrc.miniboot.entity.users.User;
import com.mrc.miniboot.utils.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUp {

   @GetMapping("signUp")
    public void controller(String name, String character, String code){

       System.out.println("code: "+code);
       String openId = Utils.code2OpenId(code);
       System.out.println(openId);
       User user = new User().setName(name).setCharacter(character).setOpenId(openId);
       System.out.println(user);
       //user.insertUser();
   }
}
