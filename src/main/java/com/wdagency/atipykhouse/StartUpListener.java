package com.wdagency.atipykhouse;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.wdagency.atipykhouse.model.Hebergement;
import com.wdagency.atipykhouse.model.ROLE;
import com.wdagency.atipykhouse.model.User;
import com.wdagency.atipykhouse.service.HebergementService;
import com.wdagency.atipykhouse.service.UserService;

@Component
public class StartUpListener {
		
	    private String appVersion;

	    @Autowired
	    private HebergementService heberRepo;
	    
	    @Autowired
	    UserService userRepo;

	    public void StartupListener(@Value("${app.version}") String appVersion) {
	        this.appVersion = appVersion;
	    }

	    @EventListener(ContextRefreshedEvent.class)
	    public void onStart() {
	    	
	    	User user = new User();
	    	user.setAge(27);
	    	Calendar toNaiss = Calendar.getInstance();
	    	toNaiss.set(Calendar.YEAR, 1993);
	    	toNaiss.set(Calendar.MONDAY, Calendar.OCTOBER);
	    	toNaiss.set(Calendar.DAY_OF_MONTH, 20);
	    	Date dateNaiss = toNaiss.getTime();
	    	user.setDateNaissance(dateNaiss);
	    	user.setEmail("stephane.gallois89@gmail.com");
	    	user.setPassword("pwd");
	    	user.setNom("Gallois");
	    	user.setPrenom("Stéphane");
	    	user.setRole(ROLE.ADMIN);
	    	userRepo.createuser(user);
	    	
	    	
	    	User user2 = new User();
	    	user2.setAge(25);
	    	Calendar toNaiss2 = Calendar.getInstance();
	    	toNaiss2.set(Calendar.YEAR, 1995);
	    	toNaiss2.set(Calendar.MONTH, Calendar.FEBRUARY);
	    	toNaiss2.set(Calendar.DAY_OF_MONTH, 15);
	    	Date dateNaiss2 = toNaiss2.getTime();
	    	user2.setDateNaissance(dateNaiss2);
	    	user2.setEmail("owner1@gmail.com");
	    	user2.setPassword("pwd");
	    	user2.setNom("Dupont");
	    	user2.setPrenom("Albert");
	    	user2.setRole(ROLE.OWNER);
	    	userRepo.createuser(user2);
	    	
	    	User usr = userRepo.findUserByEmail("owner1@gmail.com");
		    
	    	Hebergement hb = new Hebergement();
	    	hb.setLibelle("testLib");
	    	hb.setPrix(150D);
	    	hb.setType("testType");
	    	hb.setPhotos("testUrlPhoto");
	    	hb.setCouchages(5);
	    	hb.setOwner(usr);
//	    	usr.getHebergements().add(hb);
//	    	userRepo.saveAndFlush(usr);
	    	heberRepo.newHb(hb);
	    }

}
