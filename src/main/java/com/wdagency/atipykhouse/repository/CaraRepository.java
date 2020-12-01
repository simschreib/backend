package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wdagency.atipykhouse.model.Caracteristique;

public interface CaraRepository extends JpaRepository<Caracteristique, Long> {

}
