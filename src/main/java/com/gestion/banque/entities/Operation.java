package com.gestion.banque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long num_op;
private Date date;
 private double montant;
 @ManyToOne
 @JoinColumn(name="COMPTE_OP")
 private Compte compte;
 @ManyToOne
 @JoinColumn(name="EMPLOYE_OP")
 private Employe employe;
public Long getNum_op() {
	return num_op;
}

public Operation(Date date, double montant) {
	super();
	this.date = date;
	this.montant = montant;
}


public Operation() {
	super();
	// TODO Auto-generated constructor stub
}

public void setNum_op(Long num_op) {
	this.num_op = num_op;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public Compte getCompte() {
	return compte;
}
public void setCompte(Compte compte) {
	this.compte = compte;
}
public Employe getEmploye() {
	return employe;
}
public void setEmploye(Employe employe) {
	this.employe = employe;
}
 
 
 
 
}
