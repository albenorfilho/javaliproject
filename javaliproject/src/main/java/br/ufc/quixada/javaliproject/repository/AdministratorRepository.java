package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Administrator;




public interface AdministratorRepository {
	
	List<Administrator> findAll();
	
	void salvar(Administrator administrator);
	
	Administrator findById(int id);
	
	
	void remover(Administrator administrator);

}
