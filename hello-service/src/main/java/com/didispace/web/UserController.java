package com.didispace.web;

import com.didispace.service.UserMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuchuan on 2017/5/27.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMybatisService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public boolean addUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        return userService.addUser(username, password);
    }
}
