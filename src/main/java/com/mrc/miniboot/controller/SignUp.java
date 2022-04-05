package com.mrc.miniboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUp {

   @GetMapping("signUp")
    public void controller(String name, String character, String code){
       System.out.println(name);
       System.out.println(character);
       System.out.println(code);
      System.out.println("-----");
   }
}
