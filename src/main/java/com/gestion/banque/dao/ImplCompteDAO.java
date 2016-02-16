package com.gestion.banque.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gestion.banque.entities.Client;
import com.gestion.banque.entities.Compte;
import com.gestion.banque.entities.Employe;
import com.gestion.banque.entities.Groupe;
import com.gestion.banque.entities.Operation;

public class ImplCompteDAO implements ICompteDAO {
   //persistence context pour Spring plutard
	@PersistenceContext
	private EntityManager em;
   
   //on se base sur le schema de la base de données
	@Override
	public Client ajouterClient(Client c) {
		em.persist(c);	
		return c;
	}

	@Override
	public Employe ajouterEmploye(Employe e, Long employeSup) {
		//recupérer l'employé sup et l'ajouter a l'employé
		//puis on persisst employé e
		if(employeSup!=null)
		{
			Employe es=em.find(Employe.class, employeSup);
			e.setEmployeSup(es);
			
		}
		em.persist(e);
		return e;
		
	}

	@Override
	public Groupe ajouterGroupe(Groupe g) {
		em.persist(g);
		return g;
	}

	@Override
	public void ajouterEmployeGroupe(Long code_em, Long grp) {
		
           Employe e=em.find(Employe.class, code_em);
           Groupe g=em.find(Groupe.class, grp);
           
           e.getGroupes().add(g);
           g.getEmployes().add(e);    
           
	}

	@Override
	public Compte ajouterCompte(Compte c, Long code_cl, Long code_emp) {
		Client clt=em.find(Client.class, code_cl);
		Employe emplo=em.find(Employe.class, code_emp);
		c.setClient(clt);;
		c.setEmploye(emplo);;
		em.persist(c);
		return c;
	}

	@Override
	public Operation ajouterOperation(Operation o, Long code_emp, String num_cpt) {
		Employe emplo=em.find(Employe.class, code_emp);
		Compte cpt=em.find(Compte.class, num_cpt);
		o.setCompte(cpt);
		o.setEmploye(emplo);
		//persistence de operation
		em.persist(o);
		
		return o;
	}

	@Override
	public Compte consulterCompte(String c) {
		Compte cpt=em.find(Compte.class, c);
		return cpt;
	}

	@Override
	public List<Operation> consulterOperation(String num_cpt) {
		Query q=em.createQuery("select o from Operation o where o.num_cpt=:x");
		q.setParameter("x", num_cpt);
		return q.getResultList();
		
	}

	@Override
	public List<Compte> consulterComptesParClient(Long code_cl) {
		Query q=em.createQuery("select c from Compte c where c.code_clt=:x");
		q.setParameter("x", code_cl);
		return q.getResultList();
		
	}

	@Override
	public List<Compte> consulterCompteCreeEmp(Long code_emp) {
		Query q=em.createQuery("select c from Compte c where c.code_emp = :x");
		q.setParameter("x", code_emp);
		
		return q.getResultList();
	}

	@Override
	public List<Employe> consulterEmployes() {
		Query q=em.createQuery("select e from Employe e");
		return q.getResultList();
	}

	@Override
	public List<Groupe> consulterGroupes() {
		Query q=em.createQuery("Select g from Groupe g");
		return q.getResultList();
	}

	@Override
	public List<Employe> consulterEmpParGroupe(Long code_grp) {
		Query q=em.createQuery("select e from Employe e where e.groupes.code_grp =:x ");
		q.setParameter("x", code_grp);
		
		return q.getResultList();
	}

	@Override
	public List<Client> consulterClientParMot(String mc) {
		Query q=em.createQuery(" select c from Client c where c.nom_clt like :x");
		// % :  n'importe quel position

		q.setParameter("x", "%"+mc+"%");
		return q.getResultList();
	}

	

}
