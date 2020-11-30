package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wdagency.atipykhouse.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, String> {
	
	public Type findByName(String name);

}
