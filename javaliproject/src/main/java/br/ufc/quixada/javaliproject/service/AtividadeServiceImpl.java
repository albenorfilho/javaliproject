package br.ufc.quixada.javaliproject.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.repository.AtividadeRepository;
import br.ufc.quixada.javaliproject.repository.DisciplinaRepository;


@Named
public class AtividadeServiceImpl implements AtividadeService {
	
	@Inject
	private AtividadeRepository atividadeRepository;
	@Inject
	private DisciplinaService disciplinaService;

	@Override
	public List<Atividade> findAll() {
		return atividadeRepository.findAll();
	}
	
	@Override
	public List<Atividade> findByIdDisciplina(int id) {
		Disciplina disciplina = disciplinaService.findById(id);
		return atividadeRepository.findByDisciplina(disciplina);
	}
	
	@Override
	public Atividade findById(int id) {
		return atividadeRepository.findById(id);
	}

	@Override
	public void salvar(Atividade atividade, Disciplina disciplina) {
		atividadeRepository.salvar(atividade, disciplina);
		
	}

	@Override
	public void remover(int id) {
		Atividade atividade = atividadeRepository.findById(id);
		atividadeRepository.remover(atividade);
	}

}
