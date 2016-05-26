package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.javaliproject.model.Aluno;
import br.ufc.quixada.javaliproject.service.AlunoService;


@Controller
public class AlunoController {
	
	@Inject
	private AlunoService alunoService;
	
	@RequestMapping(value = "/aluno")
	public String index() {
		return "redirect:/aluno/listar";
	}
	
	@RequestMapping(value = "/aluno/listar")
	public String listar(Model model) {
		System.out.println(alunoService.findAll().size());
		model.addAttribute("alunos", alunoService.findAll());
		return "listar_aluno";  //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value ="/aluno/adicionar", method = RequestMethod.GET)
	public String adicionarForm(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "adicionar_aluno"; //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value = "/aluno/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("aluno") Aluno aluno) {
		alunoService.salvar(aluno);
		return "redirect:/aluno/listar";
	}
	
	@RequestMapping(value = "/aluno/remover/{idUsuario}", method = RequestMethod.GET)
	public String remover(@PathVariable("idUsuario") Long id) {
		alunoService.remover(id);
		return "redirect:/aluno/listar";
	}

}
