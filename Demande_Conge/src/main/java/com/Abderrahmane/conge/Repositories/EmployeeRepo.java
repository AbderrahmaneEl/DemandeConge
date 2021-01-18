package com.Abderrahmane.conge.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Abderrahmane.conge.entities.Employee;


@RepositoryRestResource
@CrossOrigin("*")
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
}
