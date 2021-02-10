package com.xzw.serverwarehouse.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzw.serverwarehouse.entity.CWarehouse;
import com.xzw.serverwarehouse.service.ICWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 仓库 前端控制器
 * </p>
 *
 * @author xzw
 * @since 2021-02-10
 */
@RestController
@RequestMapping("/cWarehouse")
public class CWarehouseController {
    @Resource
    ICWarehouseService service;

    @RequestMapping("/getOne")
    public CWarehouse getOne(CWarehouse warehouse){
        QueryWrapper<CWarehouse> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(CWarehouse::getId,warehouse.getId());
        return service.getOne(wrapper);
    }
}
