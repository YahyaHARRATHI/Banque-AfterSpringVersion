package com.gestion.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("VERSEMENT")
public class Versement extends Operation {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date date, double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}
	
	

}
