package com.serversys.thread;

/**
 * IntelliJ IDEA.
 *
 * @author 熊志伟
 * 创建时间 2020/11/12 19:49
 * 描述 学习多线程
 */
public class TestThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("run线程"+i);
        }
    }

    public static void main(String[] args) {
        TestThread1 tt = new TestThread1();
        tt.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("main线程"+i);
        }
    }
}
