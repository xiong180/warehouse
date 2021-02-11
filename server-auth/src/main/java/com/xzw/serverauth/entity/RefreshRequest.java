package com.xzw.serverauth.entity;

import lombok.Data;

/**
 * RefreshRequest;
 *
 * @author xzw
 * @date 2021/2/11 10:18
 */
@Data
public class RefreshRequest {
    private String userId;
    private String refreshToken;

}
