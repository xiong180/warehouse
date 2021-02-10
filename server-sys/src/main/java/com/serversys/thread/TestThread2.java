package com.serversys.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * IntelliJ IDEA.
 *
 * @author 熊志伟
 * 创建时间 2020/11/12 20:04
 * 描述 网络图片下载
 */
public class TestThread2 extends Thread{
    private String url;
    private String path;
    public TestThread2(String url,String path){
        this.url = url;
        this.path = path;
    }

    @Override
    public void run() {
        WebDownload download = new WebDownload();
        download.downloader(url, path);
        System.out.println("文件下载到"+path);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605193152158&di=272a07cd91296d3c3353e1adb3ff80cd&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F30%2F29%2F01300000201438121627296084016.jpg","D:\\仓穷\\1.jpg");
        TestThread2 t2 = new TestThread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605193152158&di=8588bbdc0600c6cc664801921234f26b&imgtype=0&src=http%3A%2F%2Fa4.att.hudong.com%2F22%2F59%2F19300001325156131228593878903.jpg","D:\\仓穷\\2.jpg");
        TestThread2 t3 = new TestThread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605193152157&di=f90b4353b0be67dcc0e4567efdefb9cd&imgtype=0&src=http%3A%2F%2Fa4.att.hudong.com%2F25%2F99%2F19300000421423134190997943822.jpg","D:\\仓穷\\3.jpg");

        t1.start();
        t2.start();
        t3.start();

    }
}

class WebDownload{
    public void downloader(String url,String path){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
