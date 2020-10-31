package com.wdagency.atipykhouse.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private Date creationDate;
	private Date modifDate;
	@ManyToOne
	private User author;
	@ManyToOne
	private Hebergement hebergement;
	private String content;
	
}
