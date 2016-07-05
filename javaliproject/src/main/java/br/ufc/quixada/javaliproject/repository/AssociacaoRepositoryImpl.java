package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.ufc.quixada.javaliproject.evaluationservice.Associacao;
import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Item;
@Named
public class AssociacaoRepositoryImpl implements AssociacaoRepository {
	@PersistenceContext
	protected EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Associacao> findAll() {
		Query query = em.createQuery("from Associacao");
		return query.getResultList();
	}

	
	@Override
	public List<Associacao> findByItem(Item item) {
		Query query = em.createQuery("from Associacao where item=:item");
		query.setParameter("item", item);
		return query.getResultList();
		
	}
	
	
	
	
	
	
	@Override
	@Transactional
	public void salvar(Associacao associacao) {
		em.persist(associacao);
	}

	@Override
	public Associacao findById(int id) {
		return em.find(Associacao.class, id);
	}

	@Override
	@Transactional
	public void remover(Associacao associacao) {
		em.remove(em.merge(associacao));
		
	}

	
}
