package com.serversys.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


/**
 * @author xzw
 */
public class Base64Util {

    final static Base64.Encoder ENCODER = Base64.getEncoder();
    final static Base64.Decoder DECODER = Base64.getDecoder();

    /**
     * 给字符串加密
     * @param text
     * @return
     */
    public static String encode(String text) {

        return ENCODER.encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 将加密后的字符串进行解密
     * @param encodedText
     * @return
     */
    public static String decode(String encodedText) {
        return new String(DECODER.decode(encodedText), StandardCharsets.UTF_8);
    }
}
