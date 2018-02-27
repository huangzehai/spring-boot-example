package com.hzh.web.controller;

import com.hzh.web.model.User;
import com.hzh.web.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    @ResponseBody
    String addUser(@RequestParam(required = true) String username) {
        if (StringUtils.isBlank(username)) {
            return "username should not be blank";
        }
        User user = new User();
        user.setUsername(username);
        userService.addUser(user);
        return "Add user: " + username;
    }
}
