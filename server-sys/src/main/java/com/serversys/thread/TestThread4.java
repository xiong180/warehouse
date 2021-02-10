package com.serversys.thread;

/**
 * IntelliJ IDEA.
 *
 * @author 熊志伟
 * 创建时间 2020/11/12 20:29
 * 描述 Runnable抢票
 */
public class TestThread4 implements Runnable{
    private int piao = 10;
    @Override
    public void run() {
        while (piao > 0) {
            try{
                Thread.sleep(200);
            }catch (Exception e){
                e.printStackTrace();;
            }
            System.out.println(Thread.currentThread().getName() + "-->抢到了第" + piao-- + "票");
        }
    }

    public static void main(String[] args) {
        TestThread4 t4 = new TestThread4();
        new Thread(t4,"xzw").start();
        new Thread(t4,"zzl").start();
        new Thread(t4,"ysj").start();
    }
}
