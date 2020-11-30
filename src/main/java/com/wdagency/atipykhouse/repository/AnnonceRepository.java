package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wdagency.atipykhouse.model.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

}
