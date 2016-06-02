package br.ufc.quixada.javaliproject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.javaliproject.model.Item;
import br.ufc.quixada.javaliproject.service.ItemService;



@Controller
public class ItemController {
	
	@Inject
	private ItemService itemService;
	
	@RequestMapping(value = "/item")
	public String index() {
		return "redirect:/item/listar";
	}
	
	@RequestMapping(value = "/item/listar")
	public String listar(Model model) {
		System.out.println(itemService.findAll().size());
		model.addAttribute("itens", itemService.findAll());
		return "listar_item";  //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value ="/item/adicionar", method = RequestMethod.GET)
	public String adicionarForm(Model model) {
		model.addAttribute("item", new Item());
		return "adicionar_item"; //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value = "/item/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("item") Item item) {
		itemService.salvar(item);
		return "redirect:/item/listar";
	}
	
	@RequestMapping(value = "/item/remover/{idItem}", method = RequestMethod.GET)
	public String remover(@PathVariable("idItem") int id) {
		itemService.remover(id);
		return "redirect:/item/listar";
	}

}
