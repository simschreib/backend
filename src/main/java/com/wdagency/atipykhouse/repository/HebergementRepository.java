package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wdagency.atipykhouse.model.Hebergement;

@Repository
public interface HebergementRepository extends JpaRepository<Hebergement, Long>{

	
	public Hebergement findById(String id);
}
