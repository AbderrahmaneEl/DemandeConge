package com.Abderrahmane.conge.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Abderrahmane.conge.Repositories.EmployeeRepo;
import com.Abderrahmane.conge.Repositories.ServiceRepo;
import com.Abderrahmane.conge.entities.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private ServiceRepo serviceRepo;
	
	@PostMapping("/createEmp")
	public Employee createEmployee(@RequestBody Employee employee ) {
		Employee emp = new Employee();
		emp.setNom(employee.getNom());
		emp.setPrenom(employee.getPrenom());
		emp.setEmail(employee.getEmail());
		emp.setPassword(employee.getPassword());
		emp.setMatricule(employee.getNom()+"@"+employee.getPrenom());
		emp.setServices(employee.getServices());
		
		empRepo.save(emp);
		return emp;
	}
}
