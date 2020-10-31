package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wdagency.atipykhouse.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	
	
}
