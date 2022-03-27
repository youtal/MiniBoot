package com.mrc.miniboot.mapper;

import com.mrc.miniboot.entity.users.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //SELECT count(*) FROM table WHERE a = 1 AND b = 2
    @Select("select * from users where openId = #{id}")
    User getUserByOpenId(String id);

    @Select("SELECT count(*) FROM users where openId = #{id}")
    Integer hasOpenId(String id);
}
