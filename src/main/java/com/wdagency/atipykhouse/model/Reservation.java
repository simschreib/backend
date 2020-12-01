package com.wdagency.atipykhouse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "reservation")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "id", 
scope     = String.class)
@Data
public class Reservation {

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "id", unique = true, nullable = false, length = 36)
	private String id;
	private String libelle;
	private Double prix;

	@OneToOne(targetEntity = Calendrier.class)
	@JoinColumn(name="calendrier", nullable=false)
	private Calendrier calendrier;
	
	@OneToOne(targetEntity = Hebergement.class)
	@JoinColumn(name = "hebergementID", nullable = false)
	@JsonBackReference
	private Hebergement hebergement;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "clientID", nullable=false)
	@JsonBackReference
	private User client;
}
