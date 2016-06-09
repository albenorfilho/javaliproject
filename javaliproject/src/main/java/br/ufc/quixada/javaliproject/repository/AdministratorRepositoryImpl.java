package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.javaliproject.model.Administrator;


@Named
public class AdministratorRepositoryImpl implements AdministratorRepository {
	
	@PersistenceContext
	protected EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Administrator> findAll() {
		Query query = em.createQuery("from administrator");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void salvar(Administrator administrator) {
		em.persist(administrator);
	}

	@Override
	public Administrator findById(int id) {
		return em.find(Administrator.class, id);
	}
	
	
	
	@Override
	@Transactional
	public void remover(Administrator administrator) {
		em.remove(em.merge(administrator));
		
	}

}
