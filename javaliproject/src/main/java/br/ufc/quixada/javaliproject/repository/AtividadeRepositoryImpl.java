package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Disciplina;



@Named
public class AtividadeRepositoryImpl implements AtividadeRepository {
	
	@PersistenceContext
	protected EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Atividade> findAll() {
		Query query = em.createQuery("from atividade");
		return query.getResultList();
	}

	@Override
	public List<Atividade> findByDisciplina(Disciplina disciplina) {
		Query query = em.createQuery("from atividade where disciplina=:disciplina");
		query.setParameter("disciplina", disciplina );
		return query.getResultList();
	}
	
	
	@Override
	@Transactional
	public void salvar(Atividade atividade, Disciplina disciplina) {
		atividade.setDisciplina(disciplina);
		em.persist(atividade);
	}

	@Override
	public Atividade findById(int id) {
		return em.find(Atividade.class, id);
	}

	@Override
	@Transactional
	public void remover(Atividade atividade) {
		
		String consulta = "delete from atividade where idAtividade = :idAtividade";
        Query query = em.createQuery(consulta);
        query.setParameter("idAtividade", atividade.getIdAtividade());
        query.executeUpdate();
	
	}

}
