package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wdagency.atipykhouse.model.Caracteristiques;

public interface CaraRepository extends JpaRepository<Caracteristiques, Long> {

}
