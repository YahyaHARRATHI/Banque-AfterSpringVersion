package com.gestion.banque.dao;

import java.util.Date;
import java.util.List;

import com.gestion.banque.entities.Client;
import com.gestion.banque.entities.Compte;
import com.gestion.banque.entities.Employe;
import com.gestion.banque.entities.Groupe;
import com.gestion.banque.entities.Operation;

public interface ICompteDAO {
	
	public Client ajouterClient(Client c);
	public Employe ajouterEmploye(Employe e,Long employeSup);
	public Groupe ajouterGroupe(Groupe g);
	public void ajouterEmployeGroupe(Long code_em,Long grp);
	public Compte ajouterCompte(Compte c,Long code_cl,Long code_emp);
	public Operation ajouterOperation(Operation o, Long code_emp, String num_cpt);


	
	
	public Compte consulterCompte(String c);
	
	public List<Operation> consulterOperation(String num_cpt);
	public List<Compte> consulterComptesParClient(Long code_cl);
	public List<Compte> consulterCompteCreeEmp(Long code_emp);
	public List<Employe> consulterEmployes();
	public List<Groupe> consulterGroupes();
	public List<Employe> consulterEmpParGroupe(Long code_grp);
	public List<Client> consulterClientParMot(String mc);
	
	

}
