package br.ufc.quixada.javaliproject.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.javaliproject.model.Usuario;
import br.ufc.quixada.javaliproject.repository.UsuarioRepository;


@Named
public class UsuarioServiceImpl implements UsuarioService {
	
	@Inject
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}


	@Override
	public void remover(Long id) {
		Usuario usuario = usuarioRepository.findById(id);
		usuarioRepository.remover(usuario);
	}
	
	@Override
	public Usuario getUsuario(String username){
		return usuarioRepository.findByUsername(username);
	}

}
