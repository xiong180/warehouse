package com.serversys.web.mapper;

import org.apache.ibatis.annotations.Param;
import com.serversys.web.entity.User;

import java.util.List;

/**
 * @author 熊志伟
 * 创建时间  2020-12-31 20:55
 * 描述
 */
public interface UserDao_xml {
    List<User> getAllUser();

    User getUserById(@Param("userId") String userId);
}
