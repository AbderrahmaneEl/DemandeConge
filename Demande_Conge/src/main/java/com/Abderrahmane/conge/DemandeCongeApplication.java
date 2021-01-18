package com.Abderrahmane.conge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.Abderrahmane.conge.Repositories.ServiceRepo;
import com.Abderrahmane.conge.Repositories.TypeCongeRepo;
import com.Abderrahmane.conge.entities.Employee;
import com.Abderrahmane.conge.entities.Service;
import com.Abderrahmane.conge.entities.TypeConge;

@SpringBootApplication
public class DemandeCongeApplication implements CommandLineRunner{
	 @Autowired
	 private RepositoryRestConfiguration repositoryRestConfiguration;
	 
	 @Autowired
	 private TypeCongeRepo congeRepo;
	 
	 @Autowired
	 private ServiceRepo serviceRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemandeCongeApplication.class, args);
	}
	
	
	public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Employee.class,Service.class);
       congeRepo.save(new TypeConge("Congé sans solde"));
        congeRepo.save(new TypeConge("Congé pris Payé"));
        congeRepo.save(new TypeConge("Congé payé non chômé"));
        
        serviceRepo.save(new Service("Informatique"));
        serviceRepo.save(new Service("Ressource Humaine"));
        serviceRepo.save(new Service("Comptabilité"));
        serviceRepo.save(new Service("Direction Générale"));
        serviceRepo.save(new Service("super hiérarchique"));
	}

}
