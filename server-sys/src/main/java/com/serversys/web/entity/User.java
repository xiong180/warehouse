package com.serversys.web.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xzw
 * @Description user实体
 * @create 2020-12-27 18:46
 */
@Data
public class User implements Serializable {
    private String userId;
    private String userName;
    private Integer age;
    private Integer sex;



    public User(String userId, String userName, int age, int sex){
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }

    public User(){}
}
