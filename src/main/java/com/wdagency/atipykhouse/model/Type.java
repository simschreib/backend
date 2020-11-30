package com.wdagency.atipykhouse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name="type")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name", scope = String.class)
public class Type {
	
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "id", unique = true, nullable = false, length = 36)
	private String id;
	
	@Column(name = "name", unique = true, nullable = false, length = 36)
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "types",
	joinColumns = @JoinColumn(name = "typeID"),
	inverseJoinColumns = @JoinColumn(name = "caracteristiqueName"))
	private List<Caracteristiques> caracteristique;
	
}
