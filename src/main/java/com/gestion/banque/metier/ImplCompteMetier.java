package com.gestion.banque.metier;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gestion.banque.dao.ICompteDAO;
import com.gestion.banque.entities.Client;
import com.gestion.banque.entities.Compte;
import com.gestion.banque.entities.Employe;
import com.gestion.banque.entities.Groupe;
import com.gestion.banque.entities.Operation;
import com.gestion.banque.entities.Retrait;
import com.gestion.banque.entities.Versement;

@Transactional
public class ImplCompteMetier implements ICompteMetier {
	
	private ICompteDAO dao;
	
	

	public ICompteDAO getDao() {
		return dao;
	}

	public void setDao(ICompteDAO dao) {
		this.dao = dao;
	}

	@Override
	public Client ajouterClient(Client c) {
		
		return dao.ajouterClient(c);
	}

	@Override
	public Employe ajouterEmploye(Employe e, Long code_emp_sup) {
		
		return dao.ajouterEmploye(e, code_emp_sup);
	}

	@Override
	public Groupe ajouterGroupe(Groupe g) {
		
		return dao.ajouterGroupe(g);
	}

	@Override
	public Compte ajouterCompte(Compte c, Long code_emp, Long code_clt) {
		
		return dao.ajouterCompte(c, code_clt, code_emp);
	}

	@Override
	public void ajouterEmployeAGroupe(Long code_emp, Long code_grp) {
		
		dao.ajouterEmployeGroupe(code_emp, code_grp);
	}

	@Override
	public Compte consulterCompte(String num_cpt) {
		
		return dao.consulterCompte(num_cpt);
	}

	@Override
	public List<Operation> consulterOperation(String num_cpt) {
		
		return dao.consulterOperation(num_cpt);
	}

	@Override
	public List<Compte> consulterComptePArClient(Long comte_clt) {
		
		return dao.consulterComptesParClient(comte_clt);
	}

	@Override
	public List<Compte> consulterCompteParEmploye(Long code_emp) {
		
		return dao.consulterCompteCreeEmp(code_emp);
	}

	@Override
	public List<Employe> consulterEmploye() {
		
		return dao.consulterEmployes();
	}

	@Override
	public List<Groupe> consulterGroupe() {
		
		return dao.consulterGroupes();
	}

	@Override
	public List<Employe> consulterEmployeParGroupe(Long code_grp) {
		
		return dao.consulterEmpParGroupe(code_grp);
	}

	@Override
	public List<Client> consulterClientPArMot(String mc) {
		
		return dao.consulterClientParMot(mc);
	}

	@Override
	public void retrait(double montant, Long code_emp, String num_cpt) {
		dao.ajouterOperation(new Retrait(new Date(), montant), code_emp, num_cpt);
		//mise a jour manuel du solde de la table Compte car base données relationnel
		Compte c=dao.consulterCompte(num_cpt);
		c.setSolde(c.getSolde()+montant);
	}

	@Override
	public void verser(double montant, Long code_emp, String num_cpt) {
		dao.ajouterOperation(new Versement(new Date(), montant), code_emp, num_cpt);
		
		Compte c=dao.consulterCompte(num_cpt);
		c.setSolde(c.getSolde()-montant);
		
	}

	@Override
	public void virer(double montant, Long code_emp, String num_cpt1, String num_cpt2) {
		// verser dans un compte 
		//puis retirer de l'autre compte
		retrait(montant, code_emp, num_cpt1);
		verser(montant, code_emp, num_cpt2);
		
	}
	
	

}
