package br.ufc.quixada.javaliproject.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.javaliproject.evaluationservice.Associacao;
import br.ufc.quixada.javaliproject.model.Atividade;
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
	public List<Item> findByAtividade(Atividade atividade) {
		return itemRepository.findByAtividade(atividade);
	}
	
	@Override
	public Item findById(int id) {
		return itemRepository.findById(id);
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

	@Override
	public List<Associacao> findASSByItemId(int id) {
		return itemRepository.findASSByItemId(id);
		
	}

}
