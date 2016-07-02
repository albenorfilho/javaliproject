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
public class ItemRepositoryImpl implements ItemRepository {
	
	@PersistenceContext
	protected EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Item> findAll() {
		Query query = em.createQuery("from item");
		return query.getResultList();
	}

	
	@Override
	public List<Item> findByAtividade(Atividade atividade) {
		Query query = em.createQuery("from item where atividade=:atividade");
		query.setParameter("atividade", atividade);
		return query.getResultList();
		
	}
	
	
	
	
	
	
	@Override
	@Transactional
	public void salvar(Item item) {
		em.persist(item);
	}

	@Override
	public Item findById(int id) {
		return em.find(Item.class, id);
	}

	@Override
	@Transactional
	public void remover(Item item) {
		em.remove(em.merge(item));
		
	}

}
