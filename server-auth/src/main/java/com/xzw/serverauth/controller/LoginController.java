package com.xzw.serverauth.controller;

import com.xzw.serverauth.entity.LoginRequest;
import com.xzw.serverauth.entity.LoginResponse;
import com.xzw.serverauth.entity.RefreshRequest;
import com.xzw.serverjwt.ResponseResult;
import com.xzw.serverjwt.enums.ResponseCodeEnum;
import com.xzw.serverjwt.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * LoginController;
 *
 * @author xzw
 * @date 2021/2/11 10:03
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class LoginController {
    @Value("${secretKey:123456}")
    private String secretKey;

    @Value("${userId:20}")
    private String userId;
    @Value("${authName:admin}")
    private String authName;
    @Value("${pwd:1}")
    private String pwd;

    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Validated LoginRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseResult.error(ResponseCodeEnum.PARAMETER_ILLEGAL.getCode(), ResponseCodeEnum.PARAMETER_ILLEGAL.getMessage());
        }
        String username = request.getUsername();
        String password = request.getPassword();
        log.info("账号：{}",username);
        log.info("密码：{}",password);
        //  假设查询到用户ID是1001
        if (this.authName.equals(username) && this.pwd.equals(password)) {
            //  生成Token
            String token = JwtUtil.generateToken(userId, secretKey);

            //  生成刷新Token
            String refreshToken = UUID.randomUUID().toString().replace("-", "");

            //  放入缓存
            HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();

            /**
             * 如果可以允许用户退出后token如果在有效期内仍然可以使用的话，那么就不需要存Redis
             * 因为，token要跟用户做关联的话，就必须得每次都带一个用户标识，
             * 那么校验token实际上就变成了校验token和用户标识的关联关系是否正确，且token是否有效
             */

            //String key = MD5Encoder.encode(userId.getBytes());

            String key = userId;
            hashOperations.put(key, "token", token);
            hashOperations.put(key, "refreshToken", refreshToken);
            stringRedisTemplate.expire(key, JwtUtil.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);

            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setUserId(this.userId);
            loginResponse.setToken(token);
            loginResponse.setRefreshToken(refreshToken);
            loginResponse.setUserName(authName);

            return ResponseResult.success(loginResponse);
        }

        return ResponseResult.error(ResponseCodeEnum.LOGIN_ERROR.getCode(), ResponseCodeEnum.LOGIN_ERROR.getMessage());
    }

    @GetMapping("/logout")
    public ResponseResult logout(@RequestParam("userId") String userId) {
        Set<String> keys = stringRedisTemplate.keys(userId);
        assert keys != null;
        keys.forEach(System.out::println);
        stringRedisTemplate.delete(userId);
        return ResponseResult.success();
    }

    @PostMapping("/refreshToken")
    public ResponseResult refreshToken(@RequestBody @Validated RefreshRequest request, BindingResult bindingResult) {
        String userId = request.getUserId();
        String refreshToken = request.getRefreshToken();
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        String key = userId;
        String originalRefreshToken = hashOperations.get(key, "refreshToken");
        if (StringUtils.isBlank(originalRefreshToken) || !originalRefreshToken.equals(refreshToken)) {
            return ResponseResult.error(ResponseCodeEnum.REFRESH_TOKEN_INVALID.getCode(), ResponseCodeEnum.REFRESH_TOKEN_INVALID.getMessage());
        }

        //  生成新token
        String newToken = JwtUtil.generateToken(userId, secretKey);
        hashOperations.put(key, "token", newToken);
        stringRedisTemplate.expire(userId, JwtUtil.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);

        return ResponseResult.success(newToken);
    }

}
