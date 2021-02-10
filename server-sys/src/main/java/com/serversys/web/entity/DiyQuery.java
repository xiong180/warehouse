package com.serversys.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 熊志伟
 * 创建时间  2021-01-01 17:01
 * 描述
 */
@Data
public class DiyQuery {
    private String id;
    private String name;
    private String key;
    private String sql;
    private String dataSource;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8",locale = "zh")
    private Date createDate;

}
