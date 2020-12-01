package com.wdagency.atipykhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wdagency.atipykhouse.model.Calendrier;
import com.wdagency.atipykhouse.service.CalendrierService;

@CrossOrigin
@RestController
@RequestMapping("calendar")
public class CalendrierController {

	@Autowired CalendrierService calendrierService;
	
	@GetMapping(value="/allCalendars")
	public List<Calendrier> getTypes() {
		return calendrierService.getAll();
	}
}
