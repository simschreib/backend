package com.wdagency.atipykhouse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdagency.atipykhouse.model.Hebergement;
import com.wdagency.atipykhouse.repository.HebergementRepository;

@Service
public class HerbergementService {
	
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
	
	public Hebergement newHb(Hebergement hb) {
		hbRepo.save(hb);
		return hb;
	}
	
	public Hebergement pacthOne(Hebergement hbToPatch) {
		Hebergement hbData = hbRepo.findById(hbToPatch.getId().toString());
		hbData.setType(hbToPatch.getType());
		hbData.setPrix(hbToPatch.getPrix());
		hbData.setPhotos(hbData.getPhotos());
		hbData.setLibelle(hbData.getLibelle());
		hbData.setCouchages(hbToPatch.getCouchages());
		hbRepo.save(hbData);
		return hbData;
	}

}