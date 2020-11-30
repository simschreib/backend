package com.wdagency.atipykhouse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.wdagency.atipykhouse.model.Calendrier;
import com.wdagency.atipykhouse.model.Caracteristiques;
import com.wdagency.atipykhouse.model.Hebergement;
import com.wdagency.atipykhouse.model.ROLE;
import com.wdagency.atipykhouse.model.Reservation;
import com.wdagency.atipykhouse.model.Type;
import com.wdagency.atipykhouse.model.User;
import com.wdagency.atipykhouse.repository.CaraRepository;
import com.wdagency.atipykhouse.repository.TypeRepository;
import com.wdagency.atipykhouse.service.HebergementService;
import com.wdagency.atipykhouse.service.UserService;

@Component
public class StartUpListener {
		
	    private String appVersion;

	    @Autowired
	    private HebergementService heberRepo;
	    
	    @Autowired
	    private TypeRepository typeRepo;
	    
	    @Autowired
	    CaraRepository caraRepo;
	    
	    @Autowired
	    UserService userRepo;

	    public void StartupListener(@Value("${app.version}") String appVersion) {
	        this.appVersion = appVersion;
	    }

	    @EventListener(ContextRefreshedEvent.class)
	    public void onStart() {
	    	
	    	Type cabane = new Type();
	    	cabane.setName("Cabane");
	    	typeRepo.save(cabane);
	    	
	    	List<Caracteristiques> caras = new ArrayList<>();
	    	Caracteristiques surface = new Caracteristiques();
	    	surface.setName("surface");
	    	caras.add(surface);
	    	
	    	Type cabaneData = typeRepo.findByName("Cabane");
	    	cabaneData.setCaracteristique(caras);
	    	typeRepo.save(cabaneData);
	    	
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
	    	userRepo.createUser(user);
	    	
	    	
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
	    	userRepo.createUser(user2);
	    	
	    	User usr = userRepo.findUserByEmail("owner1@gmail.com");
	    	
	    	User client = new User();
	    	client.setAge(33);
	    	Calendar toNaissance = Calendar.getInstance();
	    	toNaissance.set(Calendar.YEAR, 1987);
	    	toNaissance.set(Calendar.MONTH, Calendar.APRIL);
	    	toNaissance.set(Calendar.DAY_OF_MONTH, 14);
	    	Date dateNaissance = toNaissance.getTime();
	    	client.setDateNaissance(dateNaissance);
	    	client.setEmail("client@gmail.com");
	    	client.setPassword("pwd");
	    	client.setNom("Customer");
	    	client.setPrenom("Monsieur");
	    	client.setRole(ROLE.PUBLIC);
	    	userRepo.createUser(client);

	    	Hebergement hb = new Hebergement();
	    	hb.setType(cabaneData);
	    	hb.setOwner(usr);
	    	hb.setNotation(3);
	    	hb.setPrice(57);
	    	hb.setRooms(3);
	    	hb.setCapacity(4);
	    	hb.setName("La Cabane du Singe");

	    	heberRepo.newHb(hb);


	    	Calendrier calendrier = new Calendrier();
	    	Date date = new Date();
	    	calendrier.setDateDebut(date);
	    	calendrier.setDateFin(date);
	    	calendrier.setHebergement(hb);
	    	
	    	Reservation reserv = new Reservation();
	    	reserv.setClient(client);
	    	reserv.setCalendrier(calendrier);
	    	reserv.setHebergement(hb);
	    	reserv.setLibelle("libelle");
	    	reserv.setPrix(250.0D);

	    }

}
