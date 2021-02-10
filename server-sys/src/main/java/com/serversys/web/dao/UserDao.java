package com.serversys.web.dao;


import com.serversys.web.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int insertUser(User user);

    List<Map<String,Object>> getUserListByUserId(String userId);
}
