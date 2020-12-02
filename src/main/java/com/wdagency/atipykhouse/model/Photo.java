package com.wdagency.atipykhouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "photo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "id", 
scope     = String.class)
@Data
public class Photo {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id", unique = true, nullable = false, length = 36, insertable=false, updatable=false)
	private String id;
    
	@Column(name="file")
	@Lob
	private byte[] file;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity = Hebergement.class)
	private Hebergement hebergement;
}
