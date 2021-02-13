package com.xzw.serverwarehouse.mapper;

import com.xzw.serverwarehouse.entity.Warehouse;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * 仓库(Warehouse)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-13 16:37:04
 */
public interface WarehouseMapper extends BaseMapper<Warehouse>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Warehouse queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Warehouse> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param warehouse 实例对象
     * @return 对象列表
     */
    List<Warehouse> queryAll(Warehouse warehouse);

    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    int insert(Warehouse warehouse);

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    int update(Warehouse warehouse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}