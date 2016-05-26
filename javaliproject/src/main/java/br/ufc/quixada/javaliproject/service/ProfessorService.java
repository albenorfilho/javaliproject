package br.ufc.quixada.javaliproject.service;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Professor;





public interface ProfessorService {
	
	List<Professor> findAll();
	
	void salvar(Professor professor);
	
	void remover(Long id);
	
	Professor getProfessor(String siape);

}

