package com.serversys.web.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.serversys.web.dao.UserDao;
import com.serversys.web.entity.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xzw
 * @Description
 * @create 2020-12-27 18:48
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertUser(User user) {
        user.setUserId("145");
        return jdbcTemplate.update("INSERT INTO user (userId, userName, age, sex) VALUES (?, ?, ?, ?)"
                , user.getUserId(), user.getUserName(), user.getAge(), user.getSex());
    }

    @Override
    public List<Map<String,Object>> getUserListByUserId(String userId) {
        String sql = "select * from user where userId = ?";
        return jdbcTemplate.queryForList(sql, userId);
    }
}
