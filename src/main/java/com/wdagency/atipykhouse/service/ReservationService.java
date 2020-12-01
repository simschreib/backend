package com.wdagency.atipykhouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wdagency.atipykhouse.model.Reservation;
import com.wdagency.atipykhouse.repository.ReservationRepository;

@Service
public class ReservationService {

	
	@Autowired
	ReservationRepository reserRepo;
	
	@Transactional
	public List<Reservation> getReservations() {
		return reserRepo.findAll();
	}
	
	@Transactional
	public Reservation findByLibelle(String libelle) {
		return reserRepo.findByLibelle(libelle);
	}
	
	@Transactional
	public Reservation saveResa(Reservation resa) {
		return reserRepo.save(resa);
	}
}
