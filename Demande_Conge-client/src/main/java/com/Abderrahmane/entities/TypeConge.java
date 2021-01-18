package com.Abderrahmane.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class TypeConge {
	
	
	private int id;
	
	private String type;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public TypeConge(String type) {
		super();
		this.type = type;
	}


	public TypeConge() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TypeConge(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	

}
