package com.xzw.serverjwt.enums;

/**
 * ResponseCodeEnum;
 *
 * @author xzw
 * @date 2021/2/11 9:44
 */
public enum ResponseCodeEnum {
    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 失败
     */
    FAIL(-1, "失败"),
    /**
     * 用户名或密码错误
     */
    LOGIN_ERROR(1000, "用户名或密码错误"),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(2000, "未知错误"),
    /**
     * 参数不合法
     */
    PARAMETER_ILLEGAL(2001, "参数不合法"),
    /**
     * 无效的Token
     */
    TOKEN_INVALID(2002, "无效的Token"),
    /**
     * 无效的签名
     */
    TOKEN_SIGNATURE_INVALID(2003, "无效的签名"),
    /**
     * token已过期
     */
    TOKEN_EXPIRED(2004, "token已过期"),
    /**
     * token缺失
     */
    TOKEN_MISSION(2005, "token缺失"),
    /**
     * 刷新Token无效
     */
    REFRESH_TOKEN_INVALID(2006, "刷新Token无效");


    private final int code;

    private final String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
