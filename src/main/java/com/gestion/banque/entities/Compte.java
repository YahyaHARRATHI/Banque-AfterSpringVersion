package com.gestion.banque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Compte implements Serializable {
	@Id
	private String num_cpt;
	private double solde;
	private Date date;
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	@ManyToOne
	@JoinColumn(name="CODE_EMPLOYE")
	private Employe employe;
	@ManyToOne
	@JoinColumn(name="CODE_CL")
	private Client client;
	public String getNum_cpt() {
		return num_cpt;
	}
	public void setNum_cpt(String num_cpt) {
		this.num_cpt = num_cpt;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Compte(String num_cpt, double solde, Date date) {
		super();
		this.num_cpt = num_cpt;
		this.solde = solde;
		this.date = date;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
