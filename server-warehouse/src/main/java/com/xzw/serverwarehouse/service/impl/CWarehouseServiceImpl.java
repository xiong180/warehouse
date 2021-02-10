package com.xzw.serverwarehouse.service.impl;

import com.xzw.serverwarehouse.entity.CWarehouse;
import com.xzw.serverwarehouse.mapper.CWarehouseMapper;
import com.xzw.serverwarehouse.service.ICWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库 服务实现类
 * </p>
 *
 * @author xzw
 * @since 2021-02-10
 */
@Service
public class CWarehouseServiceImpl extends ServiceImpl<CWarehouseMapper, CWarehouse> implements ICWarehouseService {
}
