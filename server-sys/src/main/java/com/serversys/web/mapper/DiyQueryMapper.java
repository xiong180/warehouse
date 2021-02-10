package com.serversys.web.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.serversys.web.entity.DiyQuery;

/**
 * @author 熊志伟
 * 创建时间  2021-01-01 17:00
 * 描述
 */
public interface DiyQueryMapper {
    /**
     * 根据Key获取查询对象
     * @param key key
     * @return DiyQuery
     */
    @Select("select id_ id, name_ name, key_ `key`, sql_ `sql`, createdate,dataSource from diyquery where key_ =#{key}")
    DiyQuery getQueryByKey(@Param("key") String key);
}
