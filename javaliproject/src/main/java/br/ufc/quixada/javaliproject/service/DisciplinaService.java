package br.ufc.quixada.javaliproject.service;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Aluno;
import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.model.Professor;




public interface DisciplinaService {
	
	List<Disciplina> findAll();
	
	List<Disciplina> findByIdProfessor(Professor professor);
	
	List<Disciplina> findByAluno(Aluno aluno);
	
	
	
	Disciplina findById(int id);
	
	void salvar(Disciplina disciplina);
	
	void remover(int id);

}

