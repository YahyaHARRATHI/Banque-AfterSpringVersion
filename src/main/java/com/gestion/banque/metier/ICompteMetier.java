package com.gestion.banque.metier;

import java.util.List;

import com.gestion.banque.entities.Client;
import com.gestion.banque.entities.Compte;
import com.gestion.banque.entities.Employe;
import com.gestion.banque.entities.Groupe;
import com.gestion.banque.entities.Operation;

public interface ICompteMetier {
	// apartir du schema de la base de données
	public Client ajouterClient(Client c);
	public Employe ajouterEmploye(Employe e,Long code_emp_sup);
	public Groupe ajouterGroupe(Groupe g);
	public Compte ajouterCompte(Compte c,Long code_emp,Long code_clt);
	public void ajouterEmployeAGroupe(Long code_emp,Long code_grp);
	
	public Compte consulterCompte(String num_cpt);
	
	public void  retrait(double montant,Long code_emp,String num_cpt);
	public void verser(double montant,Long code_emp,String num_cpt);
	public void virer(double montant,Long code_emp,String num_cpt1,String num_cpt2);
	
	public List<Operation>  consulterOperation(String num_cpt);
	public List<Compte> consulterComptePArClient(Long comte_clt);
	public List<Compte> consulterCompteParEmploye(Long code_emp);
	public List<Employe> consulterEmploye();
	public List<Groupe> consulterGroupe();
	public List<Employe> consulterEmployeParGroupe(Long code_grp);
	public List<Client> consulterClientPArMot(String mc);
	
	
	

}
