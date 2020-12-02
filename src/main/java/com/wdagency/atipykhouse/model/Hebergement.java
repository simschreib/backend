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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "hebergement")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "id", 
scope     = String.class)
@Data
public class Hebergement {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id", unique = true, nullable = false, length = 36, insertable=false, updatable=false)
	private String id;
    
    @Column(name = "name")
	private String name;

    @Column(name ="notation")
    private int notation;
    
    @Column(name = "price",nullable = false)
    private int price;

    @Column(name = "rooms",nullable = false)
    private int rooms;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "postalCode", nullable = false)
    private int postalCode;
    
    @Column(name = "longitude")
    private Double longitude;
    
    @Column(name = "latitude")
    private Double latitude;
    
	@OneToMany(mappedBy="hebergement", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Photo> photosIds;
	
	@Column(name="creationDate")
	private Date creationDate;
	
	@Column(name="modifDate")
	private Date modifDate;
    
	@ManyToOne(fetch= FetchType.LAZY, targetEntity = Type.class)
	@JoinColumn(name = "typeName", nullable=false)
	private Type type;
	
	@OneToMany(mappedBy="hebergement", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Commentaire> comments;
	
	@ManyToOne(fetch= FetchType.LAZY, targetEntity = User.class)
	@JsonManagedReference
	private User owner;
	
	@OneToMany(mappedBy = "hebergement", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Reservation> reservations;
	
}
