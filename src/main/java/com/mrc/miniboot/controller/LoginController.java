package com.mrc.miniboot.controller;

import com.mrc.miniboot.entity.users.Keeper;
import com.mrc.miniboot.entity.users.User;
import com.mrc.miniboot.repo.ItemRepository;
import com.mrc.miniboot.repo.KeeperRepository;
import com.mrc.miniboot.repo.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class LoginController {
    @Resource
    UserRepository userRepository;

    @Resource
    KeeperRepository keeperRepository;

    @Resource
    ItemRepository itemRepository;

    @GetMapping("login")
    public Map<String,Object> codeLogin(String openId, String project) {
        Map<String,Object> resMap = new HashMap<>();
        Optional<User> userOptional = userRepository.findById(openId);
        if (!userOptional.isPresent()) {
            resMap.put("role", "new user");
            return resMap;
        }
        User user = userOptional.get();
        //这一步是为了更新用户的登录时间
        user.setLoginCount(user.getLoginCount() + 1);
        userRepository.save(user);

        resMap.put("role", user.getRole());
        if (user.getRole().equals("keeper")) {
            //获取keeper的仓库id
            Optional<Keeper> keeperOptional = keeperRepository.findById(user.getOpenId());
            if (!keeperOptional.isPresent()) {
                resMap.put("code", 100003);
                return resMap;
            }
            Keeper keeper = keeperOptional.get();
            resMap.put("warehouseId", keeper.getWarehouseId());

            //获取该仓库所有Item
            resMap.put("items", itemRepository.findByWarehouseId(keeper.getWarehouseId()));
        }
        return resMap;
    }

    @GetMapping("signup")
    public Map<String,Object> Signup(String openId,String nickName,String userName,String role) {
        Map<String,Object> resMap = new HashMap<>();
        System.out.println(openId);
        System.out.println(nickName);
        System.out.println(userName);
        System.out.println(role);
        String[] roles = {"admin", "keeper", "guest", "buyer", "inspector"};
        if(!Arrays.asList(roles).contains(role)) {
            resMap.put("code", 100001);
            return resMap;
        }

        if (role.equals("keeper")) {
            Map<String,Integer> keepList = new HashMap<>();
            keepList.put("张化哲", 1001);
            keepList.put("宋广超", 1002);
            keepList.put("闫俊水", 1003);
            keepList.put("郭兆媛", 1003);
            keepList.put("刘茂臣", 2001);
            keepList.put("王官贺", 2002);
            keepList.put("赵海亮", 2003);
            keepList.put("王菲", 2004);
            keepList.put("赵志伟", 3001);
            keepList.put("李永照", 3002);
            keepList.put("刘政", 3003);
            if (!keepList.containsKey(userName)) {
                resMap.put("code", 100002);
                return resMap;
            }

            Keeper keeper = new Keeper().setOpenId(openId).setWarehouseId(keepList.get(userName));
            keeperRepository.save(keeper);
            resMap.put("warehouseId", keeper.getWarehouseId());
        }
        User user = new User().setOpenId(openId).setNickName(nickName).setUserName(userName).setRole(role).setLoginCount(1);
        userRepository.save(user);
        resMap.put("role", user.getRole());
        resMap.put("code", 0);
        return resMap;
    }
}


