package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.service.DisciplinaService;

@Controller
public class DisciplinaController {
	
	@Inject
	private DisciplinaService disciplinaService;
	
	
	
	@RequestMapping(value = "/listar")
	public String listar(Model model) {
		System.out.println(disciplinaService.findAll().size());
		model.addAttribute("disciplinas", disciplinaService.findAll());
		return "listar";
	}
	
	@RequestMapping(value ="/adicionar", method = RequestMethod.GET)
	public String adicionarForm(Model model) {
		model.addAttribute("disciplina", new Disciplina());
		return "adicionar";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("disciplina") Disciplina disciplina) {
		disciplinaService.salvar(disciplina);
		return "redirect:/listar";
	}
	
	@RequestMapping(value = "/remover/{id}", method = RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id) {
		disciplinaService.remover(id);
		return "redirect:/listar";
	}

}
