package com.xzw.serverjwt.utils;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xzw.serverjwt.enums.ResponseCodeEnum;
import com.xzw.serverjwt.exception.TokenAuthenticationException;

import java.util.Date;

/**
 * JwtUtil;
 *
 * @author xzw
 * @date 2021/2/11 9:39
 */

public class JwtUtil {
    public static final long TOKEN_EXPIRE_TIME = 7200 * 1000;
    private static final String ISSUER = "wareHouse";

    /**
     * 生成Token
     *
     * @param username  用户标识（不一定是用户名，有可能是用户ID或者手机号什么的）
     * @param secretKey secretKey
     * @return String
     */
    public static String generateToken(String username, String secretKey) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Date now = new Date();
        Date expireTime = new Date(now.getTime() + TOKEN_EXPIRE_TIME);

        return JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(now)
                .withExpiresAt(expireTime)
                .withClaim("userId", username)
                .sign(algorithm);
    }

    /**
     * 校验Token
     *
     * @param token token
     * @param secretKey secretKey
     */
    public static void verifyToken(String token, String secretKey) throws TokenAuthenticationException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier jwtVerifier = JWT.require(algorithm).withIssuer(ISSUER).build();
            jwtVerifier.verify(token);
        } catch (JWTDecodeException jwtDecodeException) {
            throw new TokenAuthenticationException(ResponseCodeEnum.TOKEN_INVALID.getCode(), ResponseCodeEnum.TOKEN_INVALID.getMessage());
        } catch (SignatureVerificationException signatureVerificationException) {
            throw new TokenAuthenticationException(ResponseCodeEnum.TOKEN_SIGNATURE_INVALID.getCode(), ResponseCodeEnum.TOKEN_SIGNATURE_INVALID.getMessage());
        } catch (TokenExpiredException tokenExpiredException) {
            throw new TokenAuthenticationException(ResponseCodeEnum.TOKEN_EXPIRED.getCode(), ResponseCodeEnum.TOKEN_INVALID.getMessage());
        } catch (Exception ex) {
            throw new TokenAuthenticationException(ResponseCodeEnum.UNKNOWN_ERROR.getCode(), ResponseCodeEnum.UNKNOWN_ERROR.getMessage());
        }
    }

    /**
     * 从Token中提取用户信息
     *
     * @param token token
     * @return  String
     */
    public static String getUserInfo(String token) {
        DecodedJWT deCodedJwt = JWT.decode(token);
        return deCodedJwt.getClaim("userId").asString();
    }
}

