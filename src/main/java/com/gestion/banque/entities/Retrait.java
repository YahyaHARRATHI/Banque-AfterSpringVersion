package com.gestion.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("RETRAIT")
public class Retrait extends Operation {

	public Retrait() {
		super();
	}

	public Retrait(Date date, double montant) {
		super(date, montant);
	}



}
