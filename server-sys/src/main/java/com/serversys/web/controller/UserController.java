package com.serversys.web.controller;

import com.serversys.web.entity.User;
import com.xzw.serverjwt.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.serversys.web.dao.UserDao;
import com.serversys.web.mapper.UserDao_myBatis;
import com.serversys.web.mapper.UserDao_xml;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xzw
 * @Description
 * @create 2020-12-27 18:52
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserDao userDao;

    @Resource
    private UserDao_myBatis userDaoMyBatis;

    @Resource
    private UserDao_xml userDaoXml;


    @RequestMapping("/insertUser")
    public String insertUser(User user){
        int i = userDao.insertUser(user);
        return i>0 ? "success":"fail";
    }

    @RequestMapping("/insertUser_mybatis")
    public String insertUser_mybatis(User user){
        int i = userDaoMyBatis.insertUser(user);
        return i>0 ? "success":"fail";
    }

    @RequestMapping("/getUserLitByUserId")
    public List<Map<String,Object>>getUserLitByUserId(String userId){
        return userDao.getUserListByUserId(userId);
    }

    @RequestMapping("/getAllUserList")
    public List<User>getAllUserList(){
        return userDaoMyBatis.queryAllUser();
    }

    @RequestMapping("/getAllUser_xml")
    public List<User>getAllUser_xml(){
        return userDaoXml.getAllUser();
    }

    @RequestMapping("/getUserById_xml")
    public User getUserById_xml(String userId){
        User user = userDaoXml.getUserById(userId);
        log.info("user:{}",user);
        return user;
    }
    @RequestMapping("/catchException")
    public void catchException(){
        throw new NullPointerException("空指针异常了~");
    }

    /**
     * 获取当前登录的用户
     * @return User
     */
    @GetMapping("/getInfo")
    public User getInfo(String token){
        String userId = JwtUtil.getUserInfo(token);
        log.info("userId:{}",userId);
        return this.userDaoXml.getUserById(userId);
    }
}
