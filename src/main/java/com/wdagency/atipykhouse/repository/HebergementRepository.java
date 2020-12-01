package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wdagency.atipykhouse.model.Hebergement;

@Repository
public interface HebergementRepository extends PagingAndSortingRepository<Hebergement, String>, JpaSpecificationExecutor<Hebergement> {
	
	public Hebergement findByName(String name);
}
