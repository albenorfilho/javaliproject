package br.ufc.quixada.javaliproject.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	@Autowired
	private ServletContext servletContext;
	
	
	@RequestMapping(value ="/listar")
	public String listar(Model model) {
		
		model.addAttribute("disciplinas", disciplinaService.findAll());
		return "listar";
	}
	
	
	@RequestMapping(value ="/professor/adicionarDisciplina", method = RequestMethod.GET)
	public String adicionarForm(Model model) {
		model.addAttribute("disciplina", new Disciplina());
		return "professor/adicionar_disciplina";
	}
	
	@RequestMapping(value = "/professor/adicionarDisciplina", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("disciplina") Disciplina disciplina, HttpSession session) throws URISyntaxException, IOException {
		Professor professorLogado = (Professor)session.getAttribute("usuarioLogado");
		disciplina.setProfessor(professorLogado);
		disciplinaService.salvar(disciplina); 
			
		File pastaRaiz = new File(servletContext.getRealPath("/") + "Storage");
		pastaRaiz.mkdir();
		File pastaDisciplinas = new File(servletContext.getRealPath("/") + "Storage/Disciplinas");
		pastaDisciplinas.mkdir();
		File pasta = new File(servletContext.getRealPath("/") + "Storage/Disciplinas/" + disciplina.getId());

		pasta.mkdir();
		
		
		DirectoryStream <Path> diretorio = Files.newDirectoryStream(new File(servletContext.getRealPath("/") + "Storage/Disciplinas/").toPath());//
       
		
		
		
		
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
