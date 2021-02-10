package com.xzw.serverwarehouse;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzw.serverwarehouse.entity.CWarehouse;
import com.xzw.serverwarehouse.service.ICWarehouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ServerWarehouseApplicationTests {

    @Autowired
    ICWarehouseService service;

    @Test
    void contextLoads() {
        
    }

    @Test
    void plus() {
        Page<CWarehouse> page = new Page<>(1,1);
        QueryWrapper<CWarehouse> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(CWarehouse::getWareHouseAddr,"测试");
        IPage<CWarehouse> page1 = service.page(page, wrapper);
        page1.getRecords().forEach(System.out::println);
    }

}
