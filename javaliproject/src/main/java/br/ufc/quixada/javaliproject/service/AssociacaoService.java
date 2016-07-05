package br.ufc.quixada.javaliproject.service;

import java.util.List;

import br.ufc.quixada.javaliproject.evaluationservice.Associacao;
import br.ufc.quixada.javaliproject.model.Item;


public interface AssociacaoService {
	List<Associacao> findAll();
	
	List<Associacao> findByItem(Item item);
		
	Associacao findById(int n);
	
	void salvar(Associacao associacao);
	
	void remover(int id);
}
