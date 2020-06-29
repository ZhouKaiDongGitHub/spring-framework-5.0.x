package com.kzhou.spring.beandefinition;

public interface UserMapper {

    @Select("select * from user;")
    public String qureyUserList();
}
