package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Aluno;



public interface AlunoRepository {
	
	List<Aluno> findAll();
	
	void salvar(Aluno aluno);
	
	Aluno findById(int id);
	
	Aluno findByMatricula(String Matricula);
	
	void remover(Aluno aluno);

}
