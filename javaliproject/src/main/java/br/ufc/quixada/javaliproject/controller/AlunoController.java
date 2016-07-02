package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.javaliproject.model.Aluno;
import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.model.Professor;
import br.ufc.quixada.javaliproject.service.AlunoService;
import br.ufc.quixada.javaliproject.service.DisciplinaService;


@Controller
public class AlunoController {
	
	@Inject
	private AlunoService alunoService;
	@Inject
	private DisciplinaService disciplinaService;

	
	@RequestMapping(value = "/aluno")
	public String index() {
		return "redirect:/aluno/listar";
	}
	
	@Transactional
	@RequestMapping(value = "/aluno/adicionarDisciplinaAluno/{idDisciplina}", method = RequestMethod.GET)
	public String adicionarDisciplina(@PathVariable("idDisciplina") int id, HttpSession session) {
		Aluno alunoLogado = (Aluno)session.getAttribute("usuarioLogado");
		Disciplina myDisciplina = disciplinaService.findById(id);
		alunoLogado.getDisciplinas().add(myDisciplina);
		alunoService.update(alunoLogado);
		return "redirect:/aluno/indexA";
	}
	
	

	@RequestMapping(value ="/aluno/indexA") //Aqui vai a url
	public String listarDisciplinas(Model model, HttpSession session) {
		Aluno alunoLogado = (Aluno)session.getAttribute("usuarioLogado");
		
		
		model.addAttribute("disciplinas", alunoLogado.getDisciplinas());
		return "aluno/indexA"; //Aqui vai o caminho da jsp
	}
	
	
	
	@RequestMapping(value = "/aluno/listar")
	public String listar(Model model) {
		
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
		return "redirect:/login";
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/aluno/remover/{idUsuario}", method = RequestMethod.GET)
	public String remover(@PathVariable("idUsuario") int id) {
		alunoService.remover(id);
		return "redirect:/aluno/listar";
	}

}
