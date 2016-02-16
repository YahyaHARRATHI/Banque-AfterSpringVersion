package com.gestion.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Groupe implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code_grp;
	private String nom_grp;
	@ManyToMany(mappedBy="groupes")
	private Collection<Employe> employes;
	
	public Long getCode_grp() {
		return code_grp;
	}
	public void setCode_grp(Long code_grp) {
		this.code_grp = code_grp;
	}
	public String getNom_grp() {
		return nom_grp;
	}
	public void setNom_grp(String nom_grp) {
		this.nom_grp = nom_grp;
	}
	public Collection<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	public Groupe() {
		super();
	}
	public Groupe(String nom_grp) {
		super();
		this.nom_grp = nom_grp;
	}
	
	
}
