package br.ufc.quixada.javaliproject.service;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Disciplina;



public interface DisciplinaService {
	
	List<Disciplina> findAll();
	
	void salvar(Disciplina disciplina);
	
	void remover(Integer id);

}

