package com.firstSpringBoot.demo.mapper;

import com.firstSpringBoot.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user (id,name) values(#{id},#{name})")
    public void insert(User user);
}
