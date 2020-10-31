package com.wdagency.atipykhouse.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

@Data
@Entity
@Table(name = "commentaire")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "id", 
scope     = String.class)
public class Commentaire {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id", unique = true, nullable = false, length = 36, insertable=false, updatable=false)
	private String id;
	private Date creationDate;
	private Date modifDate;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "userID", nullable=false)
	private User user;

	@ManyToOne(targetEntity = Hebergement.class)
	@JoinColumn(name = "hebergementID", nullable=false)
	private Hebergement hebergement;
	private String content;
	
}
