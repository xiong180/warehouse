package com.serversys.lamdba.list;

import com.serversys.utils.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import com.serversys.lamdba.model.User;

/**
 * @author 熊志伟
 * 创建时间 2020/12/25 15:59
 * 描述
 */
public class UserTest {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u;
            if(i>3){
                u = new User(i,"name"+i,10 + i, "北京"+i);

            }else{
                u = new User(0,"name"+i,10 + i, "北京");
            }
            userList = ListUtil.getInstCreateList(userList,u);
        }

        Map<Integer, List<User>> collect = ListUtil.getListGroup(userList,User::getId);

        collect.forEach((id,user)-> System.out.println(id+" :"+user));
        System.out.println("=================================================");

        Map<Integer, User> userMap = ListUtil.getListToMap(userList, User::getId, user -> user,(user1,user2) -> user2);
        userMap.forEach((id,user)-> System.out.println(id+" :"+user));

               /* Function<T, List<Object>> compositeKey = item ->
                Arrays.asList(item.getId(), item.getAge(), item.getName());*/

        System.out.println("=================================================");
        Function<User, List<Object>> compositeKey = userItem -> ListUtil.getInstCreateList(userItem.getAddress(),userItem.getId());
        Map<List<Object>, List<User>> map = ListUtil.getListGroupByMore(userList,compositeKey);
        map.forEach((id,user)-> System.out.println(id+" :"+user));
    }
}
