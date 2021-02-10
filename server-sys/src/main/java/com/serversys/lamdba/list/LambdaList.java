package com.serversys.lamdba.list;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import com.serversys.utils.ListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 熊志伟
 * 创建时间 2020/12/23 8:41
 * 描述
 */
public class LambdaList {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list = ListUtil.getInstCreateList(list,i);
//        }
//
//        String value = ListUtil.getInst().getValue("2");
//        System.out.println(value);
//
//        List<Integer> collect = ListUtil.getListFilter(list, i -> i > 6);
//        collect.forEach(System.out::println);
//        System.out.println("原来的数组上加一个重复的");
//        list.add(1);
//        list.forEach(System.out::println);
//        System.out.println("转成map");
//        ListUtil.getListToMap(list,i -> i,i -> ++i,(k1, k2) -> k2).forEach((k,y) -> System.out.println(k+":"+y));
//        System.out.println("去重后的数组");
//        ListUtil.getListDistinct(list,i -> i).forEach(System.out::println);



//        ListUtil.getInstListToMap(list,i->i,i->i,(k1,k2)->k1).forEach((k,y)-> System.out.println(k+":"+y));

//        Map<Integer, Integer> collect1 = collect.stream().collect(Collectors.toMap(i -> i, i -> i, (k1, k2) -> k1));
//        collect1.forEach((k,y)-> System.out.println(k+":"+y));
        sumList();
    }

    public static void groupListToMap(){
        List<User> list;
        User user1 = new User("销售部","1","管理员1号");
        User user2 = new User("销售部","2","管理员2号");
        User user3 = new User("销售部","3","管理员3号");
        User user4 = new User("生产部","5","管理员4号");
        list = ListUtil.getInstCreateList(user1,user2,user3,user4);

        Map<String, List<User>> listGroup = ListUtil.getListGroup(list, User::getName);
        List<Map<String,Object>> retList = new ArrayList<>();
        listGroup.forEach((s, users) -> {
            Map<String,Object> map = new HashMap<>();
            map.put("name", s);
            map.put("users",users);
            retList.add(map);
        });
        System.out.println(ListUtil.toJsonString(retList));
    }
    public static void groupListToMap2(){
        List<Map<String,String>> list ;
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        Map<String,String> map3 = new HashMap<>();
        Map<String,String> map4 = new HashMap<>();
        map1.put("name","销售部");
        map1.put("id","1");
        map1.put("userNmae","管理员1号");
        map2.put("name","销售部");
        map2.put("id","2");
        map2.put("userNmae","管理员2号");
        map3.put("name","销售部");
        map3.put("id","3");
        map3.put("userNmae","管理员3号");
        map4.put("name","生产部");
        map4.put("id","5");
        map4.put("userNmae","管理员4号");
        list = ListUtil.getInstCreateList(map1,map2,map3,map4);
        Map<String, List<Map<String, String>>> listGroup = ListUtil.getListGroup(list, stringStringMap -> stringStringMap.get("name"));
        List<Map<String,Object>> retList = new ArrayList<>();
        listGroup.forEach((s, m) -> {
            Map<String,Object> maptemp = new HashMap<>();
            maptemp.put("name", s);
            maptemp.put("users",m);
            retList.add(maptemp);
        });
        System.out.println(ListUtil.toJsonString(retList));
    }

    public static void sumList(){
        String jsonStr = "[{\n" +
                "  \"id\":1,\n" +
                "  \"name\":\"销售部\",\n" +
                "  \"sum\":12\n" +
                "},\n" +
                "{\n" +
                "  \"id\":2,\n" +
                "  \"name\":\"销售部\",\n" +
                "  \"sum\":24\n" +
                "}]";
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);
        List<Map> lists = jsonArray.toJavaList(Map.class);

        int sum = lists.stream().mapToInt(map -> Integer.parseInt(map.get("sum").toString())).sum();
        System.out.println(sum);


    }
}

@Data
class User{
    private String name;
    private String id;
    private String userName;

    public User(String name,String id,String userName){
        this.id = id;
        this.name = name;
        this.userName = userName;
    }

}
