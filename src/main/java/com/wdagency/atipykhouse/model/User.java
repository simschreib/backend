package com.wdagency.atipykhouse.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = String.class)
@Data
public class User {

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "id", unique = true, nullable = false, length = 36)
	private String id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private int age;
	private ROLE role;
	@Column(name = "email")
	private String email;
	@Column(name = "password", nullable = false)
	private String password;


	@OneToMany(fetch=FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Hebergement> hebergements;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "reservations",
	joinColumns = @JoinColumn(name = "userID"),
	inverseJoinColumns = @JoinColumn(name = "reservationID"))
	private List<Reservation> reservations;
}
