package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import br.ufc.quixada.javaliproject.evaluationservice.Associacao;
import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Item;

public interface AssociacaoRepository {

	List<Associacao> findAll();
	
	List<Associacao> findByItem(Item item);
	
	void salvar(Associacao associacao);
	
	Associacao findById(int id);
	
	void remover(Associacao associacao);

	
}
