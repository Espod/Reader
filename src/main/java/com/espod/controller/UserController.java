package com.espod.controller;

import com.alibaba.fastjson.JSONObject;
import com.espod.entity.User;
import com.espod.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object saveUser(@RequestBody User user) {
        User userInDataBase = userService.findByUserID(user.getUserID());
        JSONObject jsonObject = new JSONObject();
        if (userInDataBase == null) {
            userService.saveUser(user);
            jsonObject.put("msg", "用户注册成功");
        } else {
            jsonObject.put("msg", "用户已存在");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object findByUserID(@RequestParam(value = "userID") String userID) {
        User user = userService.findByUserID(userID);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userID", user.getUserID());
        jsonObject.put("name", user.getName());
        jsonObject.put("phone", user.getPhone());
        return jsonObject;
    }
}
