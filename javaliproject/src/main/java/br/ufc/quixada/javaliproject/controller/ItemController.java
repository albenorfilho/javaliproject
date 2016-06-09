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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.quixada.javaliproject.model.Aluno;
import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.model.Item;
import br.ufc.quixada.javaliproject.service.AtividadeService;
import br.ufc.quixada.javaliproject.service.ItemService;



@Controller
public class ItemController {
	
	@Inject
	private ItemService itemService;
	@Inject
	private AtividadeService atividadeService;
	@Autowired
	private ServletContext servletContext;
	
	
	@RequestMapping(value = "/item/index/{id}")
	public String index(Model model, @PathVariable("id") int id) {
		Item item = itemService.findById(id);
		model.addAttribute("item", item);
		

		return "item/index_item";
	}
	
	@RequestMapping(value = "/item/listar")
	public String listar(Model model) {
		System.out.println(itemService.findAll().size());
		model.addAttribute("itens", itemService.findAll());
		return "listar_item";  //Aqui vai o nome da jsp
	}
	
	
	
	int idAtividade;
	@RequestMapping(value ="/atividade/adicionarItem/{idAtividade}", method = RequestMethod.GET)
	public String adicionarForm(Model model, @PathVariable("idAtividade") int id ) {
		model.addAttribute("item", new Item());
		//System.out.println("Nós do get pegamos o id. É esse:" + id);
		idAtividade = id;
		
		
		return "atividade/adicionar_item"; //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value = "/atividade/adicionarItem", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("item") Item item, @RequestParam("javafile") MultipartFile javafile ) throws IOException {
		
		

		Atividade atividade = atividadeService.findById(idAtividade);
		item.setAtividade(atividade);
		itemService.salvar(item);
		String caminho = servletContext.getRealPath("/") + "Storage/Disciplinas/" + atividade.getDisciplina().getId() + "/" + atividade.getIdAtividade() + "/" + item.getIdItem();
		File pasta = new File(caminho);
		pasta.mkdir();
		System.out.println(Files.isDirectory(pasta.toPath()));
		System.out.println(pasta.toPath() + "<-----------------------");
		
		DirectoryStream <Path> diretorio = Files.newDirectoryStream(new File(servletContext.getRealPath("/") + "storage/Disciplinas/" + atividade.getDisciplina().getId() + "/" + atividade.getIdAtividade()).toPath());//
        System.out.println("Diretório de Itens - Pastas:");
		for(Path path : diretorio){
         System.out.println("/" + path.getFileName());
          }
		
		System.out.println(javafile.getOriginalFilename() + "<-------------");
		File convFile = new File( caminho +"/" + javafile.getOriginalFilename());
        try {
			javafile.transferTo(convFile);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return "redirect:/atividade/index/" + idAtividade;
	}

	
	
	
		
	
	
	
	@RequestMapping(value = "/item/remover/{idItem}", method = RequestMethod.GET)
	public String remover(@PathVariable("idItem") int id) {
		itemService.remover(id);
		return "redirect:/item/listar";
	}

}
