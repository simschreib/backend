package com.wdagency.atipykhouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wdagency.atipykhouse.model.Photo;

@Repository
public interface PhotoRepository  extends JpaRepository<Photo, String>{

	public List<Photo> findByHebergementId(String hebergementId);
}
