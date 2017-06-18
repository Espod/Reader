package com.espod.controller;

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
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User findByUserID(@RequestParam(value = "userID") String userID) {
        return userService.findByUserID(userID);
    }
}
