package com.Abderrahmane.conge.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Abderrahmane.conge.Repositories.TypeCongeRepo;
import com.Abderrahmane.conge.entities.TypeConge;

@RestController
public class TypeCongController {
	
	@Autowired
	private TypeCongeRepo typeCongeRepo;
	
	@GetMapping("/allTypeCon")
	public List<TypeConge> allTypeCon(){
		List<TypeConge> typeConges = new ArrayList<>();
		
		typeConges = typeCongeRepo.findAll();
		
		return typeConges ;
	}

}
