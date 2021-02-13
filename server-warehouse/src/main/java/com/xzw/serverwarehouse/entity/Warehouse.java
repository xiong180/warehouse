package com.xzw.serverwarehouse.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
/**
 * 仓库(Warehouse)实体类
 *
 * @author makejava
 * @since 2021-02-13 16:37:03
 */
@Data
public class Warehouse implements Serializable {
    private static final long serialVersionUID = -18926449633799413L;
    /**
    * 编号
    */
    private Integer id;
    
    /**
    * 部门编码
    */
    private String departmentId;
    
    /**
    * 仓库名称
    */
    private String wareHouseName;
    
    /**
    * 仓库地址
    */
    private String wareHouseAddr;
    
    /**
    * 仓库电话
    */
    private String wareHousePhone;
    
    /**
    * 仓库负责人
    */
    private String wareHouseHead;
    
    /**
    * 增加时间
    */
    private Date installDate;
    
    /**
    * 增加人员
    */
    private String operatorId;
    
}