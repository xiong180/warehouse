package com.serversys.web.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.serversys.web.entity.User;

import java.util.List;

/**
 * @author 熊志伟
 * 创建时间 2020/12/25 9:39
 * 描述
 */
public interface UserDao_myBatis {
    @Insert("INSERT INTO user (userId, userName, age, sex) VALUES (#{userId}, #{userName}, #{age}, #{sex})")
    int insertUser(User user);

    @Select("select userId, userName, age, sex from user")
    List<User> queryAllUser();
}
