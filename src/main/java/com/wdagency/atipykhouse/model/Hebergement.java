package com.wdagency.atipykhouse.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
	private Double prix;
	private String type;
	private String libelle;
	private int couchages;
	private String photos;
	
	
	@OneToMany(mappedBy="hebergement", cascade = CascadeType.ALL)
	private List<Commentaire> comments;
	
	@ManyToMany(mappedBy="hebergementsRes", cascade = CascadeType.ALL)
	private List<User> client;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ownerID", nullable=false)
	private User owner;
	
	@ManyToOne(targetEntity = Reservation.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "reservations", nullable=true)
	private List<Reservation> reservations;

}
