package br.ufc.quixada.javaliproject.repository;
import java.util.List;

import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Disciplina;


public interface AtividadeRepository {
	
	List<Atividade> findAll();
	
	List<Atividade> findByDisciplina(Disciplina disciplina);
	
	void salvar(Atividade atividade, Disciplina disciplina);
	
	Atividade findById(int id);
	
	void remover(Atividade atividade);

}
