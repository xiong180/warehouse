package com.serversys.web.controller.system;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.serversys.utils.DiyQueryFilter;
import com.serversys.utils.Page;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 熊志伟
 * 创建时间  2021-01-01 21:19
 * 描述
 */
public class GeneralController {

    public DiyQueryFilter getQueryFilter(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String s = CharStreams.toString(new InputStreamReader(inputStream, Charsets.UTF_8));
        Map<String,Object> map = JSONObject.parseObject(s);
        JSONObject json = (JSONObject)map.get("json");
        String key = json.get("key").toString();
        String args = json.get("args").toString();
        JSONArray jsonArray = JSONArray.parseArray(args);
        List<Map<String,Object>> lists = new ArrayList<>();
        jsonArray.forEach(item -> {
            Map<String,Object> tempMap = (Map<String,Object>)item;
            lists.add(tempMap);
        });
        Integer page = Integer.valueOf(json.get("page").toString());
        Integer size = Integer.valueOf(json.get("size").toString());
        DiyQueryFilter queryFilter = new DiyQueryFilter();
        Page pageObj = new Page(page,size);
        queryFilter.setPage(pageObj);
        queryFilter.setArgs(lists);
        queryFilter.getDiyQuery().setKey(key);
        return queryFilter;
    }
}
