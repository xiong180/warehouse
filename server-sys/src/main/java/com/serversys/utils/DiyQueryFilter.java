package com.serversys.utils;

import lombok.Data;
import com.serversys.web.entity.DiyQuery;

import java.util.List;
import java.util.Map;

/**
 * @author 熊志伟
 * 创建时间  2021-01-01 20:48
 * 描述
 */
@Data
public class DiyQueryFilter {
    private Page page;
    private List<Map<String,Object>> args;
    private DiyQuery diyQuery = new DiyQuery();
}
