package br.ufc.quixada.javaliproject.service;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Usuario;


public interface UsuarioService {
	
	List<Usuario> findAll();
	
		
	void remover(int id);
	
	Usuario getUsuario(String matricula);

}

