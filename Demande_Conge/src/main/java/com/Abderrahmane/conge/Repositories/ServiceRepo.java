package com.Abderrahmane.conge.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Abderrahmane.conge.entities.Employee;
import com.Abderrahmane.conge.entities.Service;

@RepositoryRestResource
@CrossOrigin("*")
public interface ServiceRepo extends JpaRepository<Service, Long> {

}
