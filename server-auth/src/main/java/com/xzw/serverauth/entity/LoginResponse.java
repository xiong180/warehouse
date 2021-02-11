package com.xzw.serverauth.entity;

import lombok.Data;

/**
 * LoginResponse;
 *
 * @author xzw
 * @date 2021/2/11 10:13
 */
@Data
public class LoginResponse {
    private String token;
    private String refreshToken;
    private String userName;
}
