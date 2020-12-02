package com.wdagency.atipykhouse.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wdagency.atipykhouse.model.Reservation;
import com.wdagency.atipykhouse.service.ReservationService;

@CrossOrigin
@RestController
@RequestMapping("reservation")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@GetMapping(value = "/allReservations")
	public List<Reservation> getReservations() {

		return reservationService.getReservations();
	}
}