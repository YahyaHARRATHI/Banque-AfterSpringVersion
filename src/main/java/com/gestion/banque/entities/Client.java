package com.gestion.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code_cl;
	private String nom_cl;
	@OneToMany(mappedBy="client")
	private Collection<Compte> comptes;
	
	public Long getCode_cl() {
		return code_cl;
	}
	public void setCode_cl(Long code_cl) {
		this.code_cl = code_cl;
	}
	public String getNom_cl() {
		return nom_cl;
	}
	public void setNom_cl(String nom_cl) {
		this.nom_cl = nom_cl;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	public Client(String nom_cl) {
		super();
		this.nom_cl = nom_cl;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
