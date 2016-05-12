package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.javaliproject.model.Disciplina;


@Named
public class DisciplinaRepositoryImpl implements DisciplinaRepository {
	
	@PersistenceContext
	protected EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Disciplina> findAll() {
		Query query = em.createQuery("from disciplina");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void salvar(Disciplina disciplina) {
		em.persist(disciplina);
	}

	@Override
	public Disciplina findById(Integer id) {
		return em.find(Disciplina.class, id);
	}

	@Override
	@Transactional
	public void remover(Disciplina disciplina) {
		em.remove(em.merge(disciplina));
		
	}

}
