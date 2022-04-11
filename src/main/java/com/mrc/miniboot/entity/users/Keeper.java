package com.mrc.miniboot.entity.users;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Data
@Entity
@Table(name = "keepers")
@Accessors(chain = true)
public class Keeper {
    //微信用户唯一标识
    @Column(name = "openId",nullable = false)
    @Id
    private String openId;

    //仓库id
    @Column(name = "warehouseId",nullable = false)
    private Integer warehouseId;
}
