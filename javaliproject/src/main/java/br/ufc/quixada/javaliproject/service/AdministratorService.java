package br.ufc.quixada.javaliproject.service;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Administrator;


public interface AdministratorService {
	
	List<Administrator> findAll();
	
	void salvar(Administrator administrator);
	
	void remover(int id);
	
	Administrator getAdministrator(int id);

}

