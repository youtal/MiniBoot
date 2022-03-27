package com.mrc.miniboot.entity;

import com.mrc.miniboot.mapper.StudentMapper;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@Component
@Accessors(chain = true)
public class Student {
    private String id;
    private Integer sid;
    private String name;
    private String sex;
    @Resource
    StudentMapper mapper;
}
