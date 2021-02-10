package com.serversys.web.dao;

import java.util.List;
import java.util.Map;

/**
 * @author 熊志伟
 * 创建时间  2021-01-01 20:53
 * 描述
 */
public interface DiyQueryDao {
    /**
     * 自定义查询
     * @param sql sql
     * @return List
     */
    List<Map<String,Object>> diyQuery(String sql);
}
