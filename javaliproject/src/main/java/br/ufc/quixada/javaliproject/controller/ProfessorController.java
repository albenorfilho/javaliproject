package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.javaliproject.model.Professor;
import br.ufc.quixada.javaliproject.service.DisciplinaService;
import br.ufc.quixada.javaliproject.service.ProfessorService;


@Controller
public class ProfessorController {
	
	@Inject
	private ProfessorService professorService;
	@Inject
	private DisciplinaService disciplinaService;

	
	@RequestMapping(value = "/professor")
	public String index() {
		return "redirect:/professor/listar";
	}
	

	@RequestMapping(value ="/professor/indexP") //Aqui vai a url
	public String listarDisciplinas(Model model, HttpSession session) {
		Professor professorLogado = (Professor)session.getAttribute("usuarioLogado");
		
		System.out.println(disciplinaService.findAll().size());
		model.addAttribute("disciplinas", disciplinaService.findByIdProfessor(professorLogado));
		return "professor/indexP"; //Aqui vai o caminho da jsp
	}
	
	
	@RequestMapping(value = "/professor/listar")
	public String listar(Model model) {
		System.out.println(professorService.findAll().size());
		model.addAttribute("professores", professorService.findAll());
		return "listar_professor";  //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value ="/professor/adicionar", method = RequestMethod.GET)
	public String adicionarForm(Model model) {
		model.addAttribute("professor", new Professor());
		return "adicionar_professor"; //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value = "/professor/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("professor") Professor professor) {
		professorService.salvar(professor);
		return "redirect:/professor/listar";
	}
	
	@RequestMapping(value = "/professor/remover/{idUsuario}", method = RequestMethod.GET)
	public String remover(@PathVariable("idUsuario") int id) {
		professorService.remover(id);
		return "redirect:/professor/listar";
	}

}
