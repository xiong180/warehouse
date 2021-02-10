package com.serversys.web.service.impl;

import org.springframework.stereotype.Service;
import com.serversys.web.entity.DiyQuery;
import com.serversys.web.mapper.DiyQueryMapper;
import com.serversys.web.service.DiyQueryServer;

import javax.annotation.Resource;

/**
 * @author 熊志伟
 * 创建时间  2021-01-01 17:10
 * 描述
 */
@Service
public class DiyQueryServerImpl implements DiyQueryServer {
    @Resource
    private DiyQueryMapper diyQueryMapper;
    @Override
    public DiyQuery getQueryByKey(String key) {
        return diyQueryMapper.getQueryByKey(key);
    }
}
