package com.Abderrahmane.conge.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Abderrahmane.conge.Repositories.CongeRepo;
import com.Abderrahmane.conge.entities.Conge;
import com.Abderrahmane.conge.entities.TypeConge;

@RestController
public class CongeController {

	@Autowired
	private CongeRepo congeRepo;
	
	@PostMapping("/createConge")
	public Conge createConge(@RequestBody Conge conge ) {
		
		return congeRepo.save(conge);
	}
	
	@GetMapping("/allConge")
	public List<Conge> allConge(){
		List<Conge> conges = new ArrayList<>();
		conges = congeRepo.findAll();
	
		
		return conges ;
	}
	
}
