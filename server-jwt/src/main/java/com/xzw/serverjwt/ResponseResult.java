package com.xzw.serverjwt;

import com.xzw.serverjwt.enums.ResponseCodeEnum;

/**
 * ResponseResult;
 *
 * @author xzw
 * @date 2021/2/11 9:51
 */

public class ResponseResult<T> {

    private int code = 0;

    private String msg;

    private T data;

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public  static <T> ResponseResult<T> success() {
        return new ResponseResult<T>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage());
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> ResponseResult<T> error(int code, String msg) {
        return new ResponseResult<T>(code, msg);
    }

    public static <T> ResponseResult<T> error(int code, String msg, T data) {
        return new ResponseResult<T>(code, msg, data);
    }

    public boolean isSuccess() {
        return code == 0;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
