package com.wdagency.atipykhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wdagency.atipykhouse.model.Calendrier;

@Repository
public interface CalendrierRepository extends JpaRepository<Calendrier, Long> {

}
