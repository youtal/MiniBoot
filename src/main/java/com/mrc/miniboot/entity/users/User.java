package com.mrc.miniboot.entity.users;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

@Component
@Data
@Entity
@Table(name = "users")
@Accessors(chain = true)
public class User {
    //微信用户唯一标识
    @Column(name = "openId",nullable = false)
    @Id
    private String openId;

    //登录次数
    @Column(name = "loginCount",nullable = false)
    private Integer loginCount;

    //注册时间
    @Column(name = "registerTime",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Generated(GenerationTime.INSERT)
    private Timestamp registerTime;

    //上次登录时间
    @Column(name = "lastLoginTime",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Generated(GenerationTime.INSERT)
    @LastModifiedDate
    private Timestamp lastLoginTime;

    //用户名
    @Column(name = "userName")
    private String userName;


    //用户昵称
    @Column(name = "nickName")
    private String nickName;


    //角色
    @Column(name = "role")
    private String role;

}
