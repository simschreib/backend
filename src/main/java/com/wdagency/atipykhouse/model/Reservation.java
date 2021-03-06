package com.wdagency.atipykhouse.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name = "libelle")
	private String libelle;
	@Column(name = "prix")
	private Double prix;
	@Column(name = "dateDebut")
	private Date dateDebut;
	@Column(name = "dateFin")
	private Date dateFin;

//	@OneToOne(targetEntity = Calendrier.class)
//	@JoinColumn(name="calendrier", nullable=false)
//	private Calendrier calendrier;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity = Hebergement.class)
	@JoinColumn(name = "hebergementID", nullable = false)
	@JsonBackReference
	private Hebergement hebergement;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "clientID", nullable=false)
	@JsonBackReference
	private User client;
}
