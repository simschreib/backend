package com.wdagency.atipykhouse.controller;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wdagency.atipykhouse.exception.EntityException;
import com.wdagency.atipykhouse.model.User;
import com.wdagency.atipykhouse.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

	@Resource
	UserService userService;
	
	@GetMapping(value="allUsers")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping(value="login")
	public ResponseEntity<Boolean> login (@RequestParam String email, @RequestParam String password) {
		User userToCheck = new User();
		if (!email.isEmpty()) {
			try {
				userToCheck = userService.findUserByEmail(email);
				return new ResponseEntity<Boolean>(userToCheck.getPassword().contentEquals(password), HttpStatus.OK);
			} catch(Exception e) {
				return new ResponseEntity<Boolean>(userToCheck.getPassword().contentEquals(password), HttpStatus.OK);	
			}
		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		} 
	}
	
	@GetMapping(value="email={email}")
	public User getUser(@PathVariable String email) throws HibernateException {
		try {
			return userService.findUserByEmail(email);
		} catch (HibernateException e) {
			e.getMessage();
			return null;
		}
	}
	
	@GetMapping(value="id={id}")
	public User getUserById(@PathVariable String id) {
		try {
			return userService.findById(id);
		} catch (EntityException e) {
			e.getMessage();
			return null;
		}
	}
	
	@PostMapping(value="add")
	public void createUser(@RequestBody User user) {
		try {
			userService.createUser(user);
		} catch (EntityException e) {
			e.getMessage();
		}
	}
}
