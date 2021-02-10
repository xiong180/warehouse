package com.serversys.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.serversys.utils.ListUtil;
import com.serversys.utils.TreeUtil;

import java.util.List;
import java.util.Map;

/**
 * @author 熊志伟
 * 创建时间 2021/1/14 15:44
 * 描述
 */
public class DataTest {
    public static void main(String[] args) {
//        String jdbcDriver = "oracle.jdbc.OracleDriver";
//        String jdbcUrl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
//        String jdbcUsername = "GOVENGINE_OA";
//        String jdbcPassword = "Csx88921288";
//
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(jdbcDriver);
//        dataSource.setUrl(jdbcUrl);
//        dataSource.setUsername(jdbcUsername);
//        dataSource.setPassword(jdbcPassword);
//        JdbcTemplate template = new JdbcTemplate(dataSource);
//        //要改的
//        String meetingSql = "select * from OA_METTING where HYLSH = '430121-1609121988100'";
//        List<Map<String, Object>> meetingList = template.queryForList(meetingSql);
//        meetingList.forEach(meeting -> {
//            UUID uuid = UUID.randomUUID();
//            String hylsh = meeting.get("HYLSH").toString();
//            String mainid = meeting.get("ID").toString();
//            String useSql = "insert into OA_MEETING_ROOM_USE(id, hylsh, hyskey, hysshzt, mainid)" +
//                    " values ('" + uuid + "','" + hylsh + "','622','0','" + mainid + "')";
//            template.update(useSql);
//        });
        DataTest test = new DataTest();
        test.test();
    }

    public void test(){
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/ssm?serverTimezone=Asia/Shanghai";
        String jdbcUsername = "root";
        String jdbcPassword = "123456";

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        JdbcTemplate template = new JdbcTemplate(dataSource);

        String sql = "select * from sys_function";

        RowMapper<SysFunction> roleRowMapper = (rs, num)->{
            SysFunction function = new SysFunction();
            function.setFunctionId(rs.getInt("functionId"));
            function.setFunctionParentId(rs.getInt("functionParentId"));
            function.setFunctionType(rs.getString("functionType"));
            function.setFunctionIsParent(rs.getInt("functionIsParent"));
            function.setFunctionCode(rs.getString("functionCode"));
            function.setFunctionName(rs.getString("functionName"));
            function.setFunctionIcon(rs.getString("functionIcon"));
            function.setFunctionHref(rs.getString("functionHref"));
            function.setFunctionTarget(rs.getString("functionTarget"));
            function.setFunctionIsOpen(rs.getInt("functionIsOpen"));
            function.setFunctionOrderNum(rs.getInt("functionOrderNum"));
            function.setState(rs.getInt("state"));
            return function;
        };


        List<SysFunction> mapList = template.query(sql,roleRowMapper);

        String s3 = ListUtil.toJsonString(mapList);
        System.out.println(s3);
        TreeUtil<SysFunction> util = new TreeUtil<>();
        List<Map<String, Object>> treeList = util.listToTree(mapList,true,"2", "functionId", "functionParentId", "functionOrderNum", "subData");

        List<Map<String, Object>> treeList2 = util.listToTree(mapList,true,"0", "functionId", "functionParentId", "subData");
        String s = ListUtil.toJsonString(treeList);
        String s2 = ListUtil.toJsonString(treeList2);
        System.out.println(s);
        System.out.println(s2);
    }
}
