package com.Abderrahmane.entities;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conge {
	
@Override
	public String toString() {
		return "Conge [id=" + id + ", motif=" + motif + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", AvnCng=" + AvnCng + ", mntCng=" + mntCng + ", brouillon=" + brouillon + ", soumise=" + soumise
				+ ", vertifierParSup=" + vertifierParSup + ", vertifierParRH=" + vertifierParRH + ", vertifierParDG="
				+ vertifierParDG + ", emp=" + emp + ", typeConge=" + typeConge + "]";
	}


private int id;
	
	private String motif;
	private Date date_debut;
	private Date date_fin;
	private boolean AvnCng;
	private double mntCng;
	private boolean brouillon;
	private boolean soumise;
	private boolean vertifierParSup;
	private boolean vertifierParRH;
	private boolean vertifierParDG;
	
	
	
	public Conge() {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean isBrouillon() {
		return brouillon;
	}

	public void setBrouillon(boolean brouillon) {
		this.brouillon = brouillon;
	}

	public boolean isSoumise() {
		return soumise;
	}

	public void setSoumise(boolean soumise) {
		this.soumise = soumise;
	}

	public TypeConge getTypeConge() {
		return typeConge;
	}

	public void setTypeConge(TypeConge typeConge) {
		this.typeConge = typeConge;
	}


	private Employee emp;

	private TypeConge typeConge;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public boolean isAvnCng() {
		return AvnCng;
	}

	public void setAvnCng(boolean avnCng) {
		AvnCng = avnCng;
	}

	public double getMntCng() {
		return mntCng;
	}

	public void setMntCng(double mntCng) {
		this.mntCng = mntCng;
	}

	public boolean isVertifierParSup() {
		return vertifierParSup;
	}

	public void setVertifierParSup(boolean vertifierParSup) {
		this.vertifierParSup = vertifierParSup;
	}

	public boolean isVertifierParRH() {
		return vertifierParRH;
	}

	public void setVertifierParRH(boolean vertifierParRH) {
		this.vertifierParRH = vertifierParRH;
	}

	public boolean isVertifierParDG() {
		return vertifierParDG;
	}

	public void setVertifierParDG(boolean vertifierParDG) {
		this.vertifierParDG = vertifierParDG;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	

	
}
