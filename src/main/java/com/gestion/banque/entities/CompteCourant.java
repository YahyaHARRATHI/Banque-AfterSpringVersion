package com.gestion.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
 private double taux_interet;

public double getTaux_interet() {
	return taux_interet;
}

public void setTaux_interet(double taux_interet) {
	this.taux_interet = taux_interet;
}

public CompteCourant() {
	super();
	// TODO Auto-generated constructor stub
}

public CompteCourant(String num_cpt, double solde, Date date, double taux_interet) {
	super(num_cpt, solde, date);
	this.taux_interet = taux_interet;
}

 
 
 
}
