package com.mrc.miniboot.entity.users;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Component
@Data
public class Keeper extends User{
    private String wareHouseId;
}
