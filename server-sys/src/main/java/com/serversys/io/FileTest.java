package com.serversys.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 熊志伟
 * 创建时间 2021/1/30 9:56
 * 描述
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        fileReadAndWrite();
    }

    public static void fileReadAndWrite() throws IOException {
        String filePath = "F:\\Works\\Tomcat\\apache-tomcat-7.0.103\\download\\202012140002324\\申请表 (2).pdf";
        FileOutputStream output = new FileOutputStream(filePath);
        byte[] b = new byte[1024];
        FileInputStream fis = new FileInputStream(filePath);
        int len;
        while ((len = fis.read(b)) != -1) {
            output.write(b, 0, len);
        }
        output.close();
    }
}
