package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Professor;




public interface ProfessorRepository {
	
	List<Professor> findAll();
	
	void salvar(Professor professor);
	
	Professor findById(Long id);
	
	void remover(Professor professor);

}