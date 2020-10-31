package com.wdagency.atipykhouse.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wdagency.atipykhouse.model.User;
import com.wdagency.atipykhouse.service.UserService;

@CrossOrigin
@RestController(value = "users")
public class UserController {

	@Resource
	UserService userService;
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping(value="/user/email={email}")
	public User getUser(@PathVariable String email) {
		return userService.findUserByEmail(email);
	}
	
	@GetMapping(value="/{id}")
	public User getUserById(@PathVariable String id) {
		return userService.findById(id);
	}
	
	@PostMapping(value="add")
	public void createUser(User user) {
		userService.createuser(user);
	}
}
