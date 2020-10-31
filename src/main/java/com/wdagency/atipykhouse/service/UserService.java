package com.wdagency.atipykhouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wdagency.atipykhouse.model.User;
import com.wdagency.atipykhouse.repository.UserRepository;

@Service
public class UserService {

	
	@Resource
	private UserRepository userRepo;
	
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public User findById(String id) {
		return userRepo.findById(id);
	}
	
	@Transactional
	public void createuser(User user) {
		userRepo.saveAndFlush(user);
	}
}
