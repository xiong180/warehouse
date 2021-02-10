package com.serversys.web.service;

import com.serversys.web.entity.DiyQuery;

/**
 * @author 熊志伟
 * 创建时间  2021-01-01 17:09
 * 描述
 */
public interface DiyQueryServer {
    /**
     * 根据Key获取查询对象
     * @param key key
     * @return DiyQuery
     */
    DiyQuery getQueryByKey(String key);
}
