package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wdagency.atipykhouse.model.Caracteristique;
import com.wdagency.atipykhouse.model.Type;

public interface CaraRepository extends JpaRepository<Caracteristique, String> {

	public Caracteristique findByName(String name);

}
