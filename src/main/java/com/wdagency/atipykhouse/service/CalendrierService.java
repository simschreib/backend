package com.wdagency.atipykhouse.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wdagency.atipykhouse.model.Calendrier;
import com.wdagency.atipykhouse.repository.CalendrierRepository;

@Service
public class CalendrierService {
	@Resource
	CalendrierRepository calendrierRepo;
	
	public List<Calendrier> getAll() {
		return calendrierRepo.findAll();
	}
	
	public Calendrier addType(Calendrier calend) {
		return calendrierRepo.save(calend);
	}
}
