package br.ufc.quixada.javaliproject.service;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Aluno;

public interface AlunoService {
	
	List<Aluno> findAll();
	void update(Aluno aluno);
	void salvar(Aluno aluno);
	
	void remover(int id);
	
	Aluno getAluno(String matricula);

}

