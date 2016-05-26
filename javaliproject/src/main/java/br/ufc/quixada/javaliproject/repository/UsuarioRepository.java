package br.ufc.quixada.javaliproject.repository;

import java.util.List;

import br.ufc.quixada.javaliproject.model.Usuario;




public interface UsuarioRepository {
	
	List<Usuario> findAll();
	
		
	Usuario findById(Long id);
	
	Usuario findByUsername(String username);
	
	void remover(Usuario usuario);

}
