package com.serversys.web.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.serversys.web.dao.DiyQueryDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 熊志伟
 * 创建时间  2021-01-01 20:54
 * 描述
 */
@Repository
public class DiyQueryDaoImpl implements DiyQueryDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Map<String, Object>> diyQuery(String sql) {
        return jdbcTemplate.queryForList(sql);
    }
}
