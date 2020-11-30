package com.wdagency.atipykhouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wdagency.atipykhouse.model.User;
import com.wdagency.atipykhouse.repository.UserRepository;

@Service
public class UserService {

	
	@Resource
	private UserRepository userRepo;
	
	public List<User> getUsers() throws HibernateException {
		return userRepo.findAll();
	}
	
	public User findUserByEmail(String email) throws HibernateException {
		return userRepo.findByEmail(email);
	}
	
	public User findById(String id) throws HibernateException {
		return userRepo.findById(id);
	}
	
	@Transactional
	public void createUser(User user) throws HibernateException {
		userRepo.saveAndFlush(user);
	}
	
	@Transactional
	public void updateUser(User user, String userId) throws HibernateException {

		User userToUpdate = userRepo.findById(userId);
		userToUpdate.setAge(user.getAge());
		userToUpdate.setDateNaissance(user.getDateNaissance());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setNom(user.getNom());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setPrenom(user.getPrenom());
		userToUpdate.setRole(user.getRole());
		userRepo.saveAndFlush(userToUpdate);
	}
}
