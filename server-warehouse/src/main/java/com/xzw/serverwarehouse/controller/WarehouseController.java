package com.xzw.serverwarehouse.controller;

import com.xzw.serverwarehouse.entity.Warehouse;
import com.xzw.serverwarehouse.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 仓库(Warehouse)表控制层
 *
 * @author makejava
 * @since 2021-02-13 16:37:04
 */
@RestController
@RequestMapping("warehouse")
public class WarehouseController {
    /**
     * 服务对象
     */
    @Resource
    private WarehouseService warehouseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Warehouse selectOne(Integer id) {
        return this.warehouseService.queryById(id);
    }

}