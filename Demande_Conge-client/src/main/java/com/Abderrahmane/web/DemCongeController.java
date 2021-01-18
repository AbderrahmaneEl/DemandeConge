package com.Abderrahmane.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.Abderrahmane.entities.Conge;
import com.Abderrahmane.entities.Employee;
import com.Abderrahmane.entities.TypeConge;

@Controller
public class DemCongeController {
	
	@Autowired
	RestTemplate restTemplate;
	private List<TypeConge> typeconges;
	private List<Conge> conges;
	
	public void recupererTypeConge() {
		String fooResourceUrl = "http://localhost:8081/allTypeCon";
		ResponseEntity<TypeConge[]> Tcon = restTemplate.getForEntity(fooResourceUrl, TypeConge[].class);

		typeconges = Arrays.asList(Tcon.getBody());
	}
	
	@RequestMapping("/ajouterConge")
	public String index(Model model) {
		recupererTypeConge();
		model.addAttribute("typeConges", typeconges);

		return "ajouterConge";
	}
	
	@RequestMapping( value="/envoyerDemande", method = RequestMethod.POST)
	public String evoieDemande(Model model,String datedebut, String datefin,String montant,String typcongeId,String motif) throws ParseException {
		if(montant.isEmpty()) {
			montant="0";
		}

		Conge conge = new Conge();
		conge.setMntCng(Double.parseDouble(montant));
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-mm-dd");
		conge.setDate_debut(sourceFormat.parse(datedebut) );
		conge.setDate_fin(sourceFormat.parse(datefin));
		conge.setBrouillon(true);
		conge.setMotif(motif);
		recupererTypeConge();
		
		for (TypeConge typeConge : typeconges) {
			if(typeConge.getId() == Integer.parseInt(typcongeId)) {
				conge.setTypeConge(typeConge);
			}
		}
		String fooResourceUrl = "http://localhost:8081/createConge";
		 restTemplate.postForObject(fooResourceUrl, conge,Conge.class);
		
		 return "redirect:/listConge";
		 }
	
	public void recupererAllConge() {
		String fooResourceUrl = "http://localhost:8081/allConge";
		ResponseEntity<Conge[]> Tcon = restTemplate.getForEntity(fooResourceUrl, Conge[].class);

		conges = Arrays.asList(Tcon.getBody());
	}
	
	@RequestMapping("/listConge")
	public String showList(Model model) {
		recupererAllConge();
		model.addAttribute("conges", conges);

		return "ListConge";
	}
	
	@RequestMapping( value="/valideParEmp/{id}", method = RequestMethod.POST)
	public String evoieDemande( @PathVariable int id) {
		recupererAllConge();
		Conge conge = null;
		for (Conge c : conges) {
			if(c.getId() == id) {
				conge=c;
			}
		}
		conge.setBrouillon(false);
		conge.setSoumise(true);
		
		String fooResourceUrl = "http://localhost:8081/createConge";
		 restTemplate.postForObject(fooResourceUrl, conge,Conge.class);
		return "redirect:/listConge";
	}
	
	@RequestMapping("/editConge/{id}")
	public String editConge(Model model, @PathVariable int id) {
		recupererAllConge();
		Conge conge = null;
		for (Conge c : conges) {
			if(c.getId() == id) {
				conge=c;
			}
		}
		
		recupererTypeConge();
		model.addAttribute("typeConges", typeconges);
		model.addAttribute("conge", conge);

		return "SuperHiearchique/UpdateConge";
	}
	@RequestMapping( value="/editerConge/{id}", method = RequestMethod.POST)
	public String editerConge(@PathVariable int id,String datedebut, String datefin,String montant,String typcongeId,String motif) throws ParseException {
		if(montant.isEmpty()) {
			montant="0";
		}
		
		Conge conge = null;
		for (Conge c : conges) {
			if(c.getId() == id) {
				conge=c;
			}
		}
		
		conge.setMntCng(Double.parseDouble(montant));
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-mm-dd");
		conge.setDate_debut(sourceFormat.parse(datedebut) );
		conge.setDate_fin(sourceFormat.parse(datefin));
		conge.setBrouillon(false);
		conge.setSoumise(true);;
		conge.setMotif(motif);
		
		recupererTypeConge();
		
		for (TypeConge typeConge : typeconges) {
			if(typeConge.getId() == Integer.parseInt(typcongeId)) {
				conge.setTypeConge(typeConge);
			}
		}
		String fooResourceUrl = "http://localhost:8081/createConge";
		 restTemplate.postForObject(fooResourceUrl, conge,Conge.class);
		
		 return "redirect:/listConge";
		 }
	
	
	
	@RequestMapping("/consulterProfile")
	public String ConsulteProfile() {
		return "profile";
	} 
	
	
	

}
