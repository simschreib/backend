package factory;

import java.util.Calendar;
import java.util.Date;

import com.wdagency.atipykhouse.model.ROLE;
import com.wdagency.atipykhouse.model.User;

public class UserFactory {
	
	public User simpleAdminUser() {
    	User admin = new User();
    	admin.setAge(27);
    	Calendar toNaiss = Calendar.getInstance();
    	toNaiss.set(Calendar.YEAR, 1993);
    	toNaiss.set(Calendar.MONDAY, Calendar.OCTOBER);
    	toNaiss.set(Calendar.DAY_OF_MONTH, 20);
    	Date dateNaiss = toNaiss.getTime();
    	admin.setDateNaissance(dateNaiss);
    	admin.setEmail("admin@admin.com");
    	admin.setPassword("admin");
    	admin.setNom("Admin");
    	admin.setPrenom("Admin");
    	admin.setRole(ROLE.ADMIN);
    	return admin;
	}
	
	public User simpleOwnerUser() {
    	User owner = new User();
    	owner.setAge(25);
    	Calendar toNaiss2 = Calendar.getInstance();
    	toNaiss2.set(Calendar.YEAR, 1995);
    	toNaiss2.set(Calendar.MONTH, Calendar.FEBRUARY);
    	toNaiss2.set(Calendar.DAY_OF_MONTH, 15);
    	Date dateNaiss2 = toNaiss2.getTime();
    	owner.setDateNaissance(dateNaiss2);
    	owner.setEmail("owner@gmail.com");
    	owner.setPassword("pwd");
    	owner.setNom("Owner");
    	owner.setPrenom("Franck");
    	owner.setRole(ROLE.OWNER);
    	return owner;
	}
	
	public User simplePublicUser() {
    	User client = new User();
    	client.setAge(25);
    	Calendar toNaiss2 = Calendar.getInstance();
    	toNaiss2.set(Calendar.YEAR, 1995);
    	toNaiss2.set(Calendar.MONTH, Calendar.FEBRUARY);
    	toNaiss2.set(Calendar.DAY_OF_MONTH, 15);
    	Date dateNaiss2 = toNaiss2.getTime();
    	client.setDateNaissance(dateNaiss2);
    	client.setEmail("client@gmail.com");
    	client.setPassword("pwd");
    	client.setNom("Client");
    	client.setPrenom("Bob");
    	client.setRole(ROLE.PUBLIC);
    	return client;
	}

}
