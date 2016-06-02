package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.model.Professor;
import br.ufc.quixada.javaliproject.service.AtividadeService;
import br.ufc.quixada.javaliproject.service.DisciplinaService;

@Controller
public class DisciplinaController {
	
	@Inject
	private DisciplinaService disciplinaService;
	@Inject
	private AtividadeService atividadeService;
	
	
	
	@RequestMapping(value ="/listar")
	public String listar(Model model) {
		System.out.println(disciplinaService.findAll().size());
		model.addAttribute("disciplinas", disciplinaService.findAll());
		return "listar";
	}
	
	
	@RequestMapping(value ="/professor/adicionarDisciplina", method = RequestMethod.GET)
	public String adicionarForm(Model model) {
		model.addAttribute("disciplina", new Disciplina());
		return "professor/adicionar_disciplina";
	}
	
	@RequestMapping(value = "/professor/adicionarDisciplina", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("disciplina") Disciplina disciplina, HttpSession session) {
		Professor professorLogado = (Professor)session.getAttribute("usuarioLogado");
		disciplina.setProfessor(professorLogado);
		disciplinaService.salvar(disciplina);
		return "redirect:/professor/indexP";
	}
	
	@RequestMapping(value = "/professor/removerDisciplina/{id}", method = RequestMethod.GET)
	public String remover(@PathVariable("id") int id) {
		disciplinaService.remover(id);
		return "redirect:/professor/indexP";
	}
	
	@RequestMapping(value = "/disciplina/index/{id}")
	public String index(Model model, @PathVariable("id") int id) {
		Disciplina disciplina = disciplinaService.findById(id);
		model.addAttribute("disciplina", disciplina);
		
		model.addAttribute("atividades", atividadeService.findByIdDisciplina(id));

		return "disciplina/index_disciplina";
	}
	

}
