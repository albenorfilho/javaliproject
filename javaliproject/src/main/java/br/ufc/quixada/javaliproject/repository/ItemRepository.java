package br.ufc.quixada.javaliproject.repository;
import java.util.List;

import br.ufc.quixada.javaliproject.model.Item;



public interface ItemRepository {
	
	List<Item> findAll();
	
	void salvar(Item item);
	
	Item findById(int id);
	
	void remover(Item item);

}
