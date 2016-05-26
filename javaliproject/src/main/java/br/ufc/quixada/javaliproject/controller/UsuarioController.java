package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.javaliproject.service.UsuarioService;


@Controller
public class UsuarioController {
	
	@Inject
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/usuario")
	public String index() {
		return "redirect:/usuario/listar";
	}
	
	@RequestMapping(value = "/usuario/listar")
	public String listar(Model model) {
		System.out.println(usuarioService.findAll().size());
		model.addAttribute("usuarios", usuarioService.findAll());
		return "listar_usuario";  //Aqui vai o nome da jsp
	}
	
		
		
	@RequestMapping(value = "/usuario/remover/{idUsuario}", method = RequestMethod.GET)
	public String remover(@PathVariable("idUsuario") Long id) {
		usuarioService.remover(id);
		return "redirect:/usuario/listar";
	}

}
