package com.wdagency.atipykhouse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wdagency.atipykhouse.model.Hebergement;
import com.wdagency.atipykhouse.repository.HebergementRepository;

@Service
public class HebergementService {
	
	@Autowired
	HebergementRepository hbRepo;
	
	public Hebergement findOne(String id) {
		return hbRepo.findById(id);
	}

	public List<Hebergement> findAll() {
		return hbRepo.findAll();
	}
	
	public void deleteOne(String id) {
		Hebergement hbToDelete = hbRepo.findById(id); 
		hbRepo.delete(hbToDelete);
	}
	
	@Transactional
	public Hebergement newHb(Hebergement hb) {
		hbRepo.save(hb);
		return hb;
	}
	
	@Transactional
	public Hebergement pacthOne(Hebergement hbToPatch) {
		Hebergement hbData = hbRepo.findById(hbToPatch.getId().toString());
		hbData.setType(hbToPatch.getType());
		hbRepo.save(hbData);
		return hbData;
	}

}
