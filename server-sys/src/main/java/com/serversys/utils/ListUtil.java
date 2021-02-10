package com.serversys.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author 熊志伟
 * 创建时间 2020/12/25 9:39
 * 描述 对集合的操作 对原有的集合不会发生改变
 */
public class ListUtil<T,K,V> {
    private List<T> list;

    private static final int INITIAL_CAPACITY = 10;

    public ListUtil(){}

    public ListUtil(List<T> list){
        this.list = list;
    }

    /**
     * 把泛型t写入list 当list为null时会创建一个list
     * @param t t
     * @param list 传入的list 可以为null
     * @param <T> T
     * @return List<T>
     */
    @SafeVarargs
    public static <T> List<T> getInstCreateList(List<T> list, T... t){
        return new ListUtil<>(list).createList(t);
    }

    @SafeVarargs
    public static <T> List<T> getInstCreateList(T... t){
        return new ListUtil<>(new ArrayList<T>()).createList(t);
    }

    /**
     * 按条件给list过滤并产生一个新的list
     * @param list list
     * @param conditions 条件
     * @param <T> T
     * @return List<T>
     */
    public static <T> List<T> getListFilter(List<T> list,Predicate<? super T> conditions){
        return list.stream().filter(conditions).collect(Collectors.toList());
    }

    /**
     * 按照属性给list去重 并产生一个新的list
     * @param list list
     * @param keyExtractor 要去重的属性
     * @param <T> T
     * @return List<T>
     */
    public static <T> List<T> getListDistinct(List<T> list,Function<? super T, Object> keyExtractor){
        return list.stream().filter(distinctByKey(keyExtractor)).collect(Collectors.toList());
    }

    /**
     * 把list转成map集合
     * 可以按集合中的某个字段作为map的key或者value 也可以自定义
     * 当list中有重复时会报错 仅适用于没有重复值的list
     * @param list list
     * @param keyMapper key的值
     * @param valueMapper value的值
     * @param <T> T
     * @param <K> K
     * @param <V> V
     * @return Map
     */
    public static <T,K,V> Map<K,V> getListToMap(List<T> list,
                                                    Function<? super T, ? extends K> keyMapper,
                                                    Function<? super T, ? extends V> valueMapper){
        return list.stream().collect(Collectors.toMap(keyMapper,valueMapper));
    }

    /**
     * 把list转成map集合
     * 可以按集合中的某个字段作为map的key或者value 也可以自定义
     * 当list有重复的值时 按指定的方式取值
     * @param list list
     * @param keyMapper key的值
     * @param valueMapper value的值
     * @param mergeFunction 有重复时指定取值方式
     * @param <T> T
     * @param <K> K
     * @param <V> V
     * @return Map
     */
    public static <T,K,V> Map<K,V> getListToMap(List<T> list,
                                                    Function<? super T, ? extends K> keyMapper,
                                                    Function<? super T, ? extends V> valueMapper,
                                                    BinaryOperator<V> mergeFunction){
        return list.stream().collect(Collectors.toMap(keyMapper,valueMapper,mergeFunction));
    }


    /**
     * 把list按实体类的单字段值分组
     * @param list list
     * @param fieldValue 字段值
     * @param <T> t
     * @param <K> k
     * @return Map
     */
    public static <T,K> Map<K,List<T>> getListGroup(List<T> list,Function<? super T, ? extends K> fieldValue){
        return list.stream().collect(Collectors.groupingBy(fieldValue));
    }

    /**
     * 把list按实体类的多字段值分组
     * @param list list
     * @param compositeKey 分组的key的list集合
     * @param <T> T
     * @return Map
     */
    public static <T> Map<List<Object>,List<T>> getListGroupByMore(List<T> list,
                                                                   Function<? super T, ? extends List<Object>> compositeKey){
        return list.stream().collect(Collectors.groupingBy(compositeKey, Collectors.toList()));
    }

    public static <T,K,V> ListUtil<T,K,V> getInst(){
        return new ListUtil<>();
    }

    @SafeVarargs
    public final List<T> createList(T... t){
        if(t.length == 0){
            return list = new ArrayList<>();
        }
        return Collections.addAll(list, t) ? list : null;
    }
    public <A> A getValue(A a) {
        return a;
    }

    public static  <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>(INITIAL_CAPACITY);
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static <T> String toJsonString(T t){
        if(t instanceof List){
            JSONArray jsonArray = (JSONArray) JSONArray.toJSON(t);
            return jsonArray.toJSONString();
        }else if(t instanceof Map){
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(t);
            return jsonObject.toJSONString();
        }else{
            throw new RuntimeException("转换错误");
        }
    }
}
