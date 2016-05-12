package br.ufc.quixada.javaliproject.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.repository.DisciplinaRepository;


@Named
public class DisciplinaServiceImpl implements DisciplinaService {
	
	@Inject
	private DisciplinaRepository disciplinaRepository;

	@Override
	public List<Disciplina> findAll() {
		return disciplinaRepository.findAll();
	}

	@Override
	public void salvar(Disciplina disciplina) {
		disciplinaRepository.salvar(disciplina);
		
	}

	@Override
	public void remover(Integer id) {
		Disciplina disciplina = disciplinaRepository.findById(id);
		disciplinaRepository.remover(disciplina);
	}

}
