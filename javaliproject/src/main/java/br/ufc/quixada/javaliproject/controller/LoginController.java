package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.model.Professor;
import br.ufc.quixada.javaliproject.model.Usuario;
import br.ufc.quixada.javaliproject.service.DisciplinaService;
import br.ufc.quixada.javaliproject.service.ProfessorService;
import br.ufc.quixada.javaliproject.service.ProfessorServiceImpl;

@Controller
public class LoginController {

@Inject
private ProfessorService professorService;

@RequestMapping(value ="/login", method = RequestMethod.GET)
public String adicionarForm(Model model) {
    model.addAttribute("professor", new Professor());
    return "login";
}

@RequestMapping(value = "/login", method = RequestMethod.POST)
public String login(@ModelAttribute("professor") Professor professor) {        
    Professor professorLogin = null;
    try{ //Verifica se a query retorna um valor válido
        professorLogin = professorService.getProfessor(professor.getSiape());
    }catch (NoResultException nre){
        //Ignore this 
    }    
    if(professorLogin!=null){
        System.out.println(professorService.getProfessor(professor.getSiape()).getNome());
        return "listar";
    }else{
        System.out.println("Houve um erro...");
    }
return "login";
}





@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
public String loginerror(Model model) {
    model.addAttribute("erro", "UsuÃ¡rio e/ou senha invÃ¡lidos");
    return "login";
}



@RequestMapping(value = "/logout", method = RequestMethod.GET)
public String logout() {
    return "login";
}


public String doLogin(@RequestParam(value = "nome") String nome) {
    if(nome!=null){
        System.out.println(nome);
    }
    return "login";
}
}