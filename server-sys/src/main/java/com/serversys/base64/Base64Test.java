package com.serversys.base64;

import com.serversys.utils.Base64Util;

import java.io.*;

/**
 * @author 熊志伟
 * 创建时间 2021/1/5 15:29
 * 描述 读取文本文档进行解密
 */
public class Base64Test {
    public static void main(String[] args) {
        //文件路径
        String filePath="C:\\Users\\GGboy\\Desktop\\新建文本文档 (3).txt";
        File file=new File(filePath);
        BufferedReader reader = null;
        String tempString = null;
        int line =1;
        try {
            // System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
            while ((tempString = reader.readLine()) != null) {
                System.out.println("Line"+ line + ":" +tempString);
                String decode = Base64Util.decode(tempString);
                System.out.println(decode);
                line ++ ;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
