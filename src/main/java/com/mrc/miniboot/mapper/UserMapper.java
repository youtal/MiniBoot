package com.mrc.miniboot.mapper;

import com.mrc.miniboot.entity.users.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    //SELECT count(*) FROM table WHERE a = 1 AND b = 2
    @Select("select * from users where openId = #{id}")
    User getUserByOpenId(String id);

    @Select("SELECT count(*) FROM users where openId = #{id}")
    Integer hasOpenId(String id);

    @Insert("insert into users(openId,character,wareHouseId,name)"
            + "values(#{openId},#{character},#{wareHouseId},#{name})")
    void insertUser(User user);

    @Update("update users set character = #{character},wareHouseId = #{wareHouseId},name = #{name} where openId = #{openId}")
    void updateUser(User user);
}
