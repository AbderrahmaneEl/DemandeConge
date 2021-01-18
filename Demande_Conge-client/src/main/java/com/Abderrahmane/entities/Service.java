package com.Abderrahmane.entities;

import java.io.Serializable;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Service implements Serializable{
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Service() {
		super();
	}
	public Service(Long id, String nom_service, List<Employee> employees) {
		super();
		this.id = id;
		this.nom_service = nom_service;
		this.employees = employees;
	}
	public String getNom_service() {
		return nom_service;
	}
	public void setNom_service(String nom_service) {
		this.nom_service = nom_service;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	private String nom_service;
	private List<Employee> employees;
}
