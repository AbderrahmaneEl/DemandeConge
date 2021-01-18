package com.Abderrahmane.conge.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Abderrahmane.conge.Repositories.ServiceRepo;
import com.Abderrahmane.conge.entities.Service;

@RestController
public class ServiceController {
	@Autowired
	private ServiceRepo serviceRepo;
	
	@GetMapping("/allServices")
	public List<Service> allServices(){
		List<Service> services = new ArrayList<>(); 
		services = serviceRepo.findAll();
		

		return services;		
	}

}
