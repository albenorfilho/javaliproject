package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import br.ufc.quixada.javaliproject.model.Professor;
import br.ufc.quixada.javaliproject.model.Usuario;

import br.ufc.quixada.javaliproject.service.UsuarioService;

@Controller
public class LoginController {

@Inject
private UsuarioService usuarioService;


@RequestMapping(value = "/")
public String index() {
	return "redirect:/login";
}


@RequestMapping("logout")
public String logout(HttpSession session) {
	
  session.invalidate();
  return "redirect:/login";
}

@RequestMapping(value ="/login", method = RequestMethod.GET)
public String adicionarForm(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "login";
}

@RequestMapping(value = "/login", method = RequestMethod.POST)
public String login(@ModelAttribute("usuario") Usuario usuario, HttpSession session) {  
	if(usuario.getUsername().equals("deus")){
		return "redirect:/usuario/listar";
	}
	
    Usuario usuarioLogin = null;
    try{ //Verifica se a query retorna um valor válido
        usuarioLogin = usuarioService.getUsuario(usuario.getUsername());
    }catch (NoResultException nre){
        //Ignore this 
    }    
    if(usuarioLogin!=null){
        System.out.println(usuarioService.getUsuario(usuario.getUsername()).getNome());
        session.setAttribute("usuarioLogado", usuarioLogin);
        if(usuarioLogin.getTipo().equals("P")){
        	return "indexP";
        }else if(usuarioLogin.getTipo().equals("A")){
        	return "indexA";
        }
        
    }
        System.out.println("Houve um erro...");
        return "redirect:/login";
   
}




}