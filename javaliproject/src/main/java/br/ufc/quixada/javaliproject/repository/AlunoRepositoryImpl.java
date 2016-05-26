package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.javaliproject.model.Aluno;


@Named
public class AlunoRepositoryImpl implements AlunoRepository {
	
	@PersistenceContext
	protected EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Aluno> findAll() {
		Query query = em.createQuery("from aluno");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void salvar(Aluno aluno) {
		em.persist(aluno);
	}

	@Override
	public Aluno findById(Long id) {
		return em.find(Aluno.class, id);
	}
	
	@Override
	public Aluno findByMatricula(String matricula) {
		Query q = em.createQuery("FROM aluno WHERE matricula=:matricula");
		q.setParameter("matricula", matricula);
		return (Aluno) q.getSingleResult();
	}
	
	
	@Override
	@Transactional
	public void remover(Aluno aluno) {
		em.remove(em.merge(aluno));
		
	}

}
