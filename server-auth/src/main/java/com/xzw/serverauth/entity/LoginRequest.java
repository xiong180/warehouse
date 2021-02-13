package com.xzw.serverauth.entity;

import lombok.Data;

/**
 * LoginRequest;
 *
 * @author xzw
 * @date 2021/2/11 10:10
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
}
