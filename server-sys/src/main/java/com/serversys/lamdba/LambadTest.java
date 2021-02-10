package com.serversys.lamdba;

/**
 * IntelliJ IDEA.
 *
 * @author 熊志伟
 * 创建时间 2020/11/12 19:06
 * 描述 lambda
 */
public class LambadTest {
    public static void main(String[] args) {
        Lambda lambda = (a,b)->{
            System.out.println(a+b);
            System.out.println("lambda流批"+a+b);
        };
        lambda.tese(1111,666);
    }
}
