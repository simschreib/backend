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
import com.wdagency.atipykhouse.model.Caracteristique;
import com.wdagency.atipykhouse.model.Hebergement;
import com.wdagency.atipykhouse.model.ROLE;
import com.wdagency.atipykhouse.model.Reservation;
import com.wdagency.atipykhouse.model.Type;
import com.wdagency.atipykhouse.model.User;
import com.wdagency.atipykhouse.repository.CalendrierRepository;
import com.wdagency.atipykhouse.repository.CaraRepository;
import com.wdagency.atipykhouse.repository.ReservationRepository;
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
	    
	    @Autowired
	    ReservationRepository reservRepo;
	    
	    @Autowired
	    CalendrierRepository calRepo;

	    public void StartupListener(@Value("${app.version}") String appVersion) {
	        this.appVersion = appVersion;
	    }

	    @EventListener(ContextRefreshedEvent.class)
	    public void onStart() {
	    	
	    	Type cab1 = new Type();
	    	cab1.setName("Cabane dans les arbres");
	    	typeRepo.save(cab1);
	    	
	    	Type cab2 = new Type();
	    	cab2.setName("Tipi");
	    	typeRepo.save(cab2);
	    	
	    	Type cab3 = new Type();
	    	cab3.setName("Igloo");
	    	typeRepo.save(cab3);
	    	
	    	List<Caracteristique> caras = new ArrayList<>();
	    	Caracteristique surface = new Caracteristique();
	    	surface.setName("surface");
	    	surface.setValue("45");
	    	caras.add(surface);
	    	
	    	Type cabane1 = typeRepo.findByName("Cabane dans les arbres");
	    	cabane1.setCaracteristique(caras);
	    	typeRepo.save(cabane1);
	    	
	    	Caracteristique caraSurf =  caraRepo.findByName("surface");
	    	List<Caracteristique> caras2 = new ArrayList<>();
	    	caras2.add(caraSurf);
	    	
	    	Type cabane2 = typeRepo.findByName("Tipi");
	    	cabane2.setCaracteristique(caras2);
	    	typeRepo.save(cabane2);

	    	Type cabane3 = typeRepo.findByName("Igloo");
	    	cabane3.setCaracteristique(caras2);
	    	typeRepo.save(cabane3);

	    	
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
	    	
	    	User usr2 = userRepo.findUserByEmail("client@gmail.com");

	    	Hebergement hb = new Hebergement();
	    	hb.setType(cabane1);
	    	hb.setOwner(usr);
	    	hb.setNotation(3);
	    	hb.setPrice(57);
	    	hb.setRooms(3);
	    	hb.setCapacity(4);
	    	hb.setPostalCode(91);
	    	hb.setLatitude(48.609224d);
	    	hb.setLongitude(2.500969d);
	    	hb.setName("La Cabane du Singe");

	    	heberRepo.newHb(hb);
	    	
	    	Hebergement hb2 = new Hebergement();
	    	hb2.setType(cabane2);
	    	hb2.setOwner(usr);
	    	hb2.setNotation(4);
	    	hb2.setPrice(32);
	    	hb2.setRooms(2);
	    	hb2.setCapacity(4);
	    	hb2.setPostalCode(78);
	    	hb2.setLatitude(48.609224d);
	    	hb2.setLongitude(2.500969d);
	    	hb2.setName("Le Tipi perché");

	    	heberRepo.newHb(hb2);

	    	List<Reservation> reservs = new ArrayList<>();
	    	Hebergement hbForCalend = heberRepo.findByName(hb.getName());
	    	
	    	Calendrier calendrier = new Calendrier();
	    	Date date = new Date();
	    	calendrier.setDateDebut(date);
	    	calendrier.setDateFin(date);
	    	calendrier.setHebergement(hbForCalend);
	    	calRepo.save(calendrier);
	    	

	    	Reservation reserv = new Reservation();
	    	reserv.setClient(client);
	    	reserv.setCalendrier(calendrier);
	    	reserv.setHebergement(hbForCalend);
	    	reserv.setLibelle("libelle");
	    	reserv.setPrix(250.0D);
	    	reservRepo.save(reserv);
	    	
//	    	reservs.add(reserv);
//	    	hbForCalend.setReservations(reservs);
//	    	heberRepo.newHb(hbForCalend);
	    	

	    }

}
