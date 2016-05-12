package br.ufc.quixada.javaliproject.repository;
import java.util.List;

import br.ufc.quixada.javaliproject.model.Disciplina;


public interface DisciplinaRepository {
	
	List<Disciplina> findAll();
	
	void salvar(Disciplina disciplina);
	
	Disciplina findById(Integer id);
	
	void remover(Disciplina disciplina);

}
