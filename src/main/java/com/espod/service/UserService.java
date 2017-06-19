package com.espod.service;

import com.espod.entity.User;
import com.espod.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        user.setPassword(passwordToHash(user.getPassword()));
        userRepository.save(user);
    }

    public User findByUserID(String userID) {
        return userRepository.findByUserID(userID);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    private String passwordToHash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());
            byte[] src = digest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            // 字节数组转16进制字符串
            // https://my.oschina.net/u/347386/blog/182717
            for (byte aSrc : src) {
                String s = Integer.toHexString(aSrc & 0xFF);
                if (s.length() < 2) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ignore) {
        }
        return null;
    }

    public boolean comparePassword(User user, User userInDataBase) {
        return passwordToHash(user.getPassword()).equals(userInDataBase.getPassword());
    }
}
