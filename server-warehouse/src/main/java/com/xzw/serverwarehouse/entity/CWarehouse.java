package com.xzw.serverwarehouse.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 仓库
 * </p>
 *
 * @author xzw
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("C_WareHouse")
public class CWarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门编码
     */
    @TableField("DepartmentID")
    private String DepartmentID;

    /**
     * 仓库名称
     */
    @TableField("WareHouseName")
    private String WareHouseName;

    /**
     * 仓库地址
     */
    @TableField("WareHouseAddr")
    private String WareHouseAddr;

    /**
     * 仓库电话
     */
    @TableField("WareHousePhone")
    private String WareHousePhone;

    /**
     * 仓库负责人
     */
    @TableField("WareHouseHead")
    private String WareHouseHead;

    /**
     * 增加时间
     */
    @TableField("InstallDate")
    private Date InstallDate;

    /**
     * 增加人员
     */
    @TableField("OperatorID")
    private String OperatorID;


}
