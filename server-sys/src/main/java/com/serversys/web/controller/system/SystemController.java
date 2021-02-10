package com.serversys.web.controller.system;

import org.springframework.web.bind.annotation.*;
import com.serversys.utils.DiyQueryFilter;
import com.serversys.utils.ListUtil;
import com.serversys.utils.ResultMessage;
import com.serversys.web.dao.DiyQueryDao;
import com.serversys.web.entity.DiyQuery;
import com.serversys.web.service.DiyQueryServer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 熊志伟
 * 创建时间  2021-01-01 16:24
 * 描述
 */
@RestController
@RequestMapping("/sys")
public class SystemController extends GeneralController{

    private final String key = "key";
    private final String value = "value";
    @Resource
    private DiyQueryServer diyQueryServer;
    @Resource
    private DiyQueryDao queryDao;
    /**
     * 通过key获取到sql
     * 在通过args参数组装sql
     * 在通过jdbcTemplate查询数据
     * @param key key
     * @param args 参数
     * @return ResultMessage
     */
    @PostMapping("/diyQuery")
    public ResultMessage diyQuery(@RequestParam("key") String key, @RequestBody List<Map<String,Object>> args){
        args.forEach(item -> {
            if(item.get(this.key) == null || item.get(this.value) == null){
                throw new RuntimeException("请按照key和value定义参数");
            }
        });
        List<Map<String, Object>> list = ListUtil.getListDistinct(args, item -> item.get("key"));

        DiyQuery diyQueryObj = diyQueryServer.getQueryByKey(key);

        String dealSql = dealSql(diyQueryObj, list);
        List<Map<String, Object>> maps = queryDao.diyQuery(dealSql);
        return ResultMessage.success(maps,ResultMessage.SUCCESSFUL);
    }

    @PostMapping("/postDiySql")
    public ResultMessage postDiySql(HttpServletRequest request) throws IOException {
        DiyQueryFilter queryFilter = getQueryFilter(request);
        return diyQuery(queryFilter.getDiyQuery().getKey(), queryFilter.getArgs());
    }

    private String dealSql(DiyQuery obj,List<Map<String,Object>> args){
        StringBuilder firstSql = new StringBuilder("select * from ( ");
        firstSql.append(obj.getSql());
        firstSql.append(") tab where 1=1 ");

        args.forEach(item -> {
            String key = item.get(this.key).toString();
            String value = item.get(this.value).toString();
            firstSql.append(" and ").append(key).append(" = '").append(value).append("' ");
        });
        return firstSql.toString();
    }
}
