package com.didispace.service;

import com.didispace.dto.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface UserService {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String getUserByParams(@RequestParam(value="name", required = true) String name, @RequestParam(value="age", required = false) Integer age) ;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    String addUser(@RequestBody User user);

}