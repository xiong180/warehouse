package com.serversys.utils;

import lombok.Data;

/**
 * @author 熊志伟
 * 创建时间  2021-01-01 20:48
 * 描述
 */
@Data
public class Page {
    private Integer page = 1;
    private Integer size = 10;
    private Integer total;

    public Page(Integer page,Integer size){
        this.page = page;
        this.size = size;
    }
}
