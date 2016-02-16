package com.gestion.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
private double decouvert;

public double getDecouvert() {
	return decouvert;
}

public void setDecouvert(double decouvert) {
	this.decouvert = decouvert;
}

public CompteEpargne(String num_cpt, double solde, Date date, double decouvert) {
	super(num_cpt, solde, date);
	this.decouvert = decouvert;
}

public CompteEpargne() {
	super();
}




}
