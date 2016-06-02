package br.ufc.quixada.javaliproject.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.javaliproject.model.Item;
import br.ufc.quixada.javaliproject.repository.ItemRepository;



@Named
public class ItemServiceImpl implements ItemService {
	
	@Inject
	private ItemRepository itemRepository;

	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public void salvar(Item item) {
		itemRepository.salvar(item);
		
	}

	@Override
	public void remover(int id) {
		Item item = itemRepository.findById(id);
		itemRepository.remover(item);
	}

}
