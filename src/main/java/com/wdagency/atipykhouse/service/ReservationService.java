package com.wdagency.atipykhouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wdagency.atipykhouse.model.Reservation;
import com.wdagency.atipykhouse.repository.ReservationRepository;

@Service
public class ReservationService {

	
	@Resource
	ReservationRepository reserRepo;
	
	@Transactional
	public List<Reservation> getReservations() {
		return reserRepo.findAll();
	}
}
