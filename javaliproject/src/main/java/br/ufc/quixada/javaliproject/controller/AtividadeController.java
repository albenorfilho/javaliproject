package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.model.Professor;
import br.ufc.quixada.javaliproject.service.AtividadeService;
import br.ufc.quixada.javaliproject.service.DisciplinaService;




@Controller
public class AtividadeController {
	
	@Inject
	private AtividadeService atividadeService;
	@Inject
	private DisciplinaService disciplinaService;
	
	@RequestMapping(value = "/atividade")
	public String index() {
		return "redirect:/atividade/listar";
	}
	
	@RequestMapping(value = "/atividade/listar")
	public String listar(Model model) {
		System.out.println(atividadeService.findAll().size());
		model.addAttribute("itens", atividadeService.findAll());
		return "listar_atividade";  //Aqui vai o nome da jsp
	}
	int idDisciplina;
	@RequestMapping(value ="/disciplina/adicionarAtividade/{idDisciplina}", method = RequestMethod.GET)
	public String adicionarForm(Model model, @PathVariable("idDisciplina") int id) {
		model.addAttribute("atividade", new Atividade());
		System.out.println("Nós do get pegamos o id. É esse:" + id);
		idDisciplina = id;
		return "disciplina/adicionar_atividade"; //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value = "/disciplina/adicionarAtividade", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("atividade") Atividade atividade) {
		
		System.out.println("Nós do post pegamos o id. É esse:" + idDisciplina);

		Disciplina disciplina = disciplinaService.findById(idDisciplina);
		atividadeService.salvar(atividade, disciplina);
		return "redirect:/disciplina/index/" + idDisciplina;
	}
	
	@RequestMapping(value = "/disciplina/removerAtividade/{id}/{idAtividade}", method = RequestMethod.GET)
	public String removerDisciplina(@PathVariable("id") int id, @PathVariable("idAtividade") int idAtividade) {
		atividadeService.remover(idAtividade);
		return "redirect:/disciplina/index/" + id;
	}
	
	
	@RequestMapping(value = "/atividade/remover/{idAtividade}", method = RequestMethod.GET)
	public String remover(@PathVariable("idAtividade") int id) {
		atividadeService.remover(id);
		return "redirect:/atividade/listar";
	}

}
