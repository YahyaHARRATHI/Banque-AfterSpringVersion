package com.gestion.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Employe  implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code_em;
	private String nom_em;
	@ManyToOne
	@JoinColumn(name="GROUPE_EM")
	private Employe employeSup;
	@ManyToMany
	private Collection<Groupe> groupes;
	
	public Long getCode_em() {
		return code_em;
	}
	public void setCode_em(Long code_em) {
		this.code_em = code_em;
	}
	public String getNom_em() {
		return nom_em;
	}
	public void setNom_em(String nom_em) {
		this.nom_em = nom_em;
	}
	public Employe getEmployeSup() {
		return employeSup;
	}
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Employe(String nom_em) {
		super();
		this.nom_em = nom_em;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}
