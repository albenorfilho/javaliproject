package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.javaliproject.model.Administrator;
import br.ufc.quixada.javaliproject.service.AdministratorService;


@Controller
public class AdministratorController {

	@Inject
	private AdministratorService administratorService;
	
	@RequestMapping(value = "/administrator")
	public String index() {
		return "redirect:/administrator/listar";
	}
	
	@RequestMapping(value = "/administrator/listar")
	public String listar(Model model) {
		model.addAttribute("administrators", administratorService.findAll());
		return "listar_deus";  //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value ="/administrator/adicionar", method = RequestMethod.GET)
	public String adicionarForm(Model model) {
		model.addAttribute("administrator", new Administrator());
		return "deusnocomando"; //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value = "/administrator/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("administrator") Administrator administrator) {
		administratorService.salvar(administrator);
		return "redirect:/administrator/listar";
	}
	
}
