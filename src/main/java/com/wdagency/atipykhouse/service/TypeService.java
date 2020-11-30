package com.wdagency.atipykhouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wdagency.atipykhouse.model.Type;
import com.wdagency.atipykhouse.repository.TypeRepository;

@Service
public class TypeService {
	
	@Resource
	TypeRepository typeRepo;
	
	public List<Type> getAll() {
		return typeRepo.findAll();
	}
	
	public Type getType(String name) {
		return typeRepo.findByName(name);
	}

}
