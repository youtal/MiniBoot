package com.mrc.miniboot.entity.users;

import com.mrc.miniboot.mapper.UserMapper;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Data
@Accessors(chain = true)
public class User {
    private String openId;
    private Date lastLogIn;
    private String character;
    private String name;
    private String wareHouseId;

    @Resource
    UserMapper mapper;

    public User getUserById(String id){
        return mapper.getUserByOpenId(id);
    }

    public boolean hasUser(String id){
        return mapper.hasOpenId(id) > 0;
    }

    public void insertUser(){
        mapper.insertUser(this);
    }

    public void updateUser(){
        mapper.updateUser(this);
    }
}
