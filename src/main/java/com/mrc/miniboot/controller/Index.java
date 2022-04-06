package com.mrc.miniboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class Index {

    @RequestMapping(value = "index")
    @ResponseBody
    public String index(HttpServletRequest req){
        System.out.println(req);
        System.out.println(Arrays.toString(req.getParameterMap().get("code")));
        return "index page";
    }



}
