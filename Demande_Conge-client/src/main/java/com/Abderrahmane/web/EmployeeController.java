package com.Abderrahmane.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.Abderrahmane.entities.Employee;
import com.Abderrahmane.entities.Service;

@Controller
public class EmployeeController {
	

	RestTemplate restTemplate;
	private List<Service> services;

	public EmployeeController() {
		restTemplate = new RestTemplate();

		
	}
	public void recupererServices() {
		String fooResourceUrl = "http://localhost:8081/allServices";
		ResponseEntity<Service[]> serv = restTemplate.getForEntity(fooResourceUrl, Service[].class);

		services = Arrays.asList(serv.getBody());
	}

	@RequestMapping("/")
	public String index(Model model) {
		recupererServices();
		model.addAttribute("services", services);

		return "register";
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(Model model, String nom, String prenom, String email, String password,
			String confirmpassword, Long[] services) {
		if (password.equals(confirmpassword)) {
			recupererServices();
			Employee emp = new Employee();
			emp.setNom(nom);
			emp.setPrenom(prenom);
			emp.setEmail(email);
			emp.setPassword(password);
			List<Service> services2 = new ArrayList<Service>();
			for (int i = 0; i < services.length; i++) {
				if (services[i] == this.services.get(i).getId()) {
					services2.add(this.services.get(i));
				}
			}

			emp.setServices(services2);

			String fooResourceUrl = "http://localhost:8081/createEmp";
			 restTemplate.postForObject(fooResourceUrl, emp,Employee.class);
			
		}else
		{
			model.addAttribute("error_password", " password incorrect ");
			return "redirect:/?error_password="+"password incorrect";
		}
		

		return "profile";

	}

}
