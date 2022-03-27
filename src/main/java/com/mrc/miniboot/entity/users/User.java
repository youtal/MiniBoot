package com.mrc.miniboot.entity.users;

import com.mrc.miniboot.mapper.UserMapper;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Data
public class User {
    private String openId;
    private Date lastLogIn;
    private String character;

    @Resource
    UserMapper mapper;

    public User getUserById(String id){
        return mapper.getUserByOpenId(id);
    }

    public boolean hasUser(String id){
        return mapper.hasOpenId(id) > 0;
    }
}
