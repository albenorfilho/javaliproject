package br.ufc.quixada.javaliproject.repository;
import java.util.List;

import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.model.Professor;


public interface DisciplinaRepository {
	
	List<Disciplina> findAll();
	List<Disciplina> findByIdProfessor(Professor professor);
	
	void salvar(Disciplina disciplina);
	
	Disciplina findById(int id);
	
	void remover(Disciplina disciplina);

}
