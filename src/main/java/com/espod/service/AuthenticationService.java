package com.espod.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.espod.entity.User;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class AuthenticationService {
    public String getToken(User user) {
        String token = "";
        try {
            token = JWT.create()
                    .withAudience(user.getUserID().toString())   // 将 user id 保存到 token 里面
                    .sign(Algorithm.HMAC256(user.getPassword()));  // 以 password 作为 token 的密钥,这样使用密码做秘钥不好
        } catch (UnsupportedEncodingException ignore) {
        }
        return token;
    }
}

