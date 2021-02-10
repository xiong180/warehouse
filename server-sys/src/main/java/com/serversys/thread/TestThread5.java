package com.serversys.thread;

/**
 * IntelliJ IDEA.
 *
 * @author 熊志伟
 * 创建时间 2020/11/12 20:55
 * 描述 龟兔赛跑
 */
public class TestThread5 implements Runnable{
    private String winner;

    private boolean isGemaOver(int steps){
        if(winner!=null){
            return true;
        }else if(steps>=100) {
            System.out.println(Thread.currentThread().getName()+"胜利了");
            return true;
        }else{

            return false;
        }

    }
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(isGemaOver(i)){
                break;
            }
                if(Thread.currentThread().getName().equals("兔子") && i%10==0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");

        }
    }

    public static void main(String[] args) {
        TestThread5 t5 = new TestThread5();
        new Thread(t5,"乌龟").start();
        new Thread(t5,"兔子").start();
    }
}
