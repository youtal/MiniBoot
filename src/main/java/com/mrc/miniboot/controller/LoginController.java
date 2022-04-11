package com.mrc.miniboot.controller;

import com.mrc.miniboot.entity.users.User;
import com.mrc.miniboot.repo.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Optional;

@RestController
public class LoginController {
    @Resource
    UserRepository userRepository;

    @GetMapping("login")
    public String codeLogin(String openId,String project) {
        System.out.println(openId);
        System.out.println(project);
        Optional<User> userOptional = userRepository.findById(openId);
        if (!userOptional.isPresent()) {
            return "new user";
        }
        User user = userOptional.get();
        //这一步是为了更新用户的登录时间
        user.setLoginCount(user.getLoginCount() + 1);
        userRepository.save(user);

        return user.getRole();
    }

    @GetMapping("signup")
    public Integer Signup(String openId,String nickName,String userName,String role) {

        System.out.println(openId);
        System.out.println(nickName);
        System.out.println(userName);
        System.out.println(role);
        String[] roles = {"admin", "keeper", "guest", "buyer", "inspector"};
        if(!Arrays.asList(roles).contains(role))
            return 100001;
        User user = new User().setOpenId(openId).setNickName(nickName).setUserName(userName).setRole(role).setLoginCount(1);
        userRepository.save(user);
        return 0;
    }
}


