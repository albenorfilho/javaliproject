package br.ufc.quixada.javaliproject.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.javaliproject.evaluationservice.Associacao;
import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Item;
import br.ufc.quixada.javaliproject.repository.AssociacaoRepository;

@Named
public class AssociacaoServiceImpl implements AssociacaoService{

	@Inject
	private AssociacaoRepository associacaoRepository;

	@Override
	public List<Associacao> findAll() {
		return associacaoRepository.findAll();
	}
	
	@Override
	public List<Associacao> findByItem(Item item) {
		return associacaoRepository.findByItem(item);
	}
	
	@Override
	public Associacao findById(int id) {
		return associacaoRepository.findById(id);
	}

	@Override
	public void salvar(Associacao associacao) {
		associacaoRepository.salvar(associacao);
		
	}

	@Override
	public void remover(int id) {
		Associacao associacao = associacaoRepository.findById(id);
		associacaoRepository.remover(associacao);
	}

}
