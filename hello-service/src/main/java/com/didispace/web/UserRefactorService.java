package com.didispace.web;

import com.didispace.dto.User;
import com.didispace.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRefactorService implements UserService {

	@Override
	public String getUserByParams(@RequestParam(value="name", required = true) String name, @RequestParam(value="age", required = false) Integer age) {
		return "Hello " + name + " " + age;
	}

	@Override
	public String addUser(@RequestBody User user) {
		return "Hello "+ user.getName() + ", " + user.getAge();
	}

}