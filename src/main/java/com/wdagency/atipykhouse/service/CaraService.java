package com.wdagency.atipykhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdagency.atipykhouse.model.Caracteristique;
import com.wdagency.atipykhouse.repository.CaraRepository;

@Service
public class CaraService {

	@Autowired CaraRepository caraRepo;
	
	public List<Caracteristique> getCara() {
		return caraRepo.findAll();
	}
}
