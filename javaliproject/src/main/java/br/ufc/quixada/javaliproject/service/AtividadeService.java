package br.ufc.quixada.javaliproject.service;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Disciplina;




public interface AtividadeService {
	
	List<Atividade> findAll();
	
	List<Atividade> findByIdDisciplina(int n);
	
	void salvar(Atividade atividade, Disciplina disciplina);
	
	void remover(int id);

}

