package br.ufc.quixada.javaliproject.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.ufc.quixada.javaliproject.service.ItemService;




@Controller
public class AtividadeController {
	
	@Inject
	private AtividadeService atividadeService;
	@Inject
	private ItemService itemService;
	@Inject
	private DisciplinaService disciplinaService;
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = "/atividade/index/{id}")
	public String index(Model model, @PathVariable("id") int id) {
		Atividade atividade = atividadeService.findById(id);
		model.addAttribute("atividade", atividade);
		
		model.addAttribute("itens", itemService.findByAtividade(atividade));

		return "atividade/index_atividade";
	}
	
	@RequestMapping(value = "/atividade/listar")
	public String listar(Model model) {
		
		model.addAttribute("itens", atividadeService.findAll());
		return "listar_atividade";  //Aqui vai o nome da jsp
	}
	int idDisciplina;
	@RequestMapping(value ="/disciplina/adicionarAtividade/{idDisciplina}", method = RequestMethod.GET)
	public String adicionarForm(Model model, @PathVariable("idDisciplina") int id) {
		model.addAttribute("atividade", new Atividade());
		
		idDisciplina = id;
		return "disciplina/adicionar_atividade"; //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value = "/disciplina/adicionarAtividade", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("atividade") Atividade atividade) throws IOException {
		
		

		Disciplina disciplina = disciplinaService.findById(idDisciplina);
		atividadeService.salvar(atividade, disciplina);
		
		File pasta = new File(servletContext.getRealPath("/") + "Storage/Disciplinas/" + disciplina.getId() + "/" + atividade.getIdAtividade());
		pasta.mkdir();
		
		
		
		DirectoryStream <Path> diretorio = Files.newDirectoryStream(new File(servletContext.getRealPath("/") + "storage/Disciplinas/" + disciplina.getId()).toPath());//
       
		for(Path path : diretorio){
       
          }
		
		
		
		
		
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
