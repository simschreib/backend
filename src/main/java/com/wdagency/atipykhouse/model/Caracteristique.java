package com.wdagency.atipykhouse.model;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name="caracteristique", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name", scope = String.class)
public class Caracteristique {


    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id", unique = true, nullable = false, length = 36, insertable=false, updatable=false)
	private String id;
	
	@Column(name = "name", unique = true, nullable = false, length = 36)
	private String name;
	
	@Column(name="value")
	private String value;

	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "types",
	joinColumns = @JoinColumn(name = "caracteristiqueName"),
	inverseJoinColumns = @JoinColumn(name = "typeID"))
	 @JsonBackReference
	private List<Type> types;
}
