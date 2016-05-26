package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.javaliproject.model.Professor;



@Named
public class ProfessorRepositoryImpl implements ProfessorRepository {
	
	@PersistenceContext
	protected EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Professor> findAll() {
		Query query = em.createQuery("from professor");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void salvar(Professor professor) {
		em.persist(professor);
	}

	@Override
	public Professor findById(Long id) {
		return em.find(Professor.class, id);
	}
	
	@Override
	public Professor findBySiape(String siape) {
		Query q = em.createQuery("FROM professor WHERE siape=:siape");
		q.setParameter("siape", siape);
		return (Professor) q.getSingleResult();
	}
	
	
	@Override
	@Transactional
	public void remover(Professor professor) {
		em.remove(em.merge(professor));
		
	}

}
