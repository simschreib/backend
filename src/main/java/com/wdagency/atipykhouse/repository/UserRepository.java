package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wdagency.atipykhouse.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	public User findByEmail(String email);
	
	public User findById(String id);
}
