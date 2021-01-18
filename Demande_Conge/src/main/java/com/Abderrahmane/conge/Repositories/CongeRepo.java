package com.Abderrahmane.conge.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.Abderrahmane.conge.entities.Conge;

@RepositoryRestController
public interface CongeRepo extends JpaRepository<Conge, Integer> {
	
	

}
