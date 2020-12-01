package com.wdagency.atipykhouse.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.wdagency.atipykhouse.model.Type;
import com.wdagency.atipykhouse.repository.TypeRepository;

@Service
public class TypeService {
	
	@Resource
	TypeRepository typeRepo;
	
	@Transactional
	public List<Type> getAll() {
		return typeRepo.findAll();
	}
	@Transactional
	public Type getType(String name) {
		return typeRepo.findByName(name);
	}
	@Transactional
	public Type addType(Type type) {
		return typeRepo.save(type);
	}

}
