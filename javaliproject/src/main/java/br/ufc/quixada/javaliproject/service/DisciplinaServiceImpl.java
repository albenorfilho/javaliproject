package br.ufc.quixada.javaliproject.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.javaliproject.model.Aluno;
import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.model.Professor;
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
	public List<Disciplina> findByIdProfessor(Professor professor) {
		return disciplinaRepository.findByIdProfessor(professor);
	}
	
	@Override
	public List<Disciplina> findByAluno(Aluno aluno) {
		return disciplinaRepository.findByAluno(aluno);
	}
	
	
	
	@Override
	public Disciplina findById(int id) {
		return disciplinaRepository.findById(id);
	}

	@Override
	public void salvar(Disciplina disciplina) {
		disciplinaRepository.salvar(disciplina);
		
	}

	@Override
	public void remover(int id) {
		Disciplina disciplina = disciplinaRepository.findById(id);
		disciplinaRepository.remover(disciplina);
	}

}
