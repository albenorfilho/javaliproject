package br.ufc.quixada.javaliproject.service;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Item;


public interface ItemService {
	
	List<Item> findAll();
	
	List<Item> findByAtividade(Atividade atividade);
	
	Item findById(int n);
	
	void salvar(Item item);
	
	void remover(int id);

}

