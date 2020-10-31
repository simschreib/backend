package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wdagency.atipykhouse.model.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

	
	public Commentaire findById(String id);
}
