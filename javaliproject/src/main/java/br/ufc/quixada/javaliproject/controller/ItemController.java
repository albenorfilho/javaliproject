package br.ufc.quixada.javaliproject.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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

import br.ufc.quixada.javaliproject.evaluationservice.Associacao;
import br.ufc.quixada.javaliproject.evaluationservice.Avalia;
import br.ufc.quixada.javaliproject.evaluationservice.ResultadoAvaliacao;
import br.ufc.quixada.javaliproject.model.Aluno;
import br.ufc.quixada.javaliproject.model.Atividade;
import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.model.Item;
import br.ufc.quixada.javaliproject.service.AssociacaoService;
import br.ufc.quixada.javaliproject.service.AtividadeService;
import br.ufc.quixada.javaliproject.service.ItemService;



@Controller
public class ItemController {
	
	@Inject
	private ItemService itemService;
	@Inject
	private AtividadeService atividadeService;
	@Inject
	AssociacaoService associacaoService;
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
	
		model.addAttribute("itens", itemService.findAll());
		return "listar_item";  //Aqui vai o nome da jsp
	}
	
	
	
	int idAtividade;
	@RequestMapping(value ="/atividade/adicionarItem/{idAtividade}", method = RequestMethod.GET)
	public String adicionarForm(Model model, @PathVariable("idAtividade") int id ) {
		model.addAttribute("item", new Item());
		
		idAtividade = id;
		
		
		return "atividade/adicionar_item"; //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value = "/atividade/adicionarItem", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("item") Item item, @RequestParam("javafile") MultipartFile javafile ) throws IOException {
		
		

		Atividade atividade = atividadeService.findById(idAtividade);
		item.setAtividade(atividade);
		item.setArquivo(javafile.getOriginalFilename());
		for(int i = 0; i < item.getAssociacoes().size(); i++){
			item.getAssociacoes().get(i).setItem(item);
		}
		System.out.println((item.getAssociacoes() != null) ? item.getAssociacoes().size() : "nulo"); 
		itemService.salvar(item);
		String caminho = servletContext.getRealPath("/") + "Storage/Disciplinas/" + atividade.getDisciplina().getId() + "/" + atividade.getIdAtividade() + "/" + item.getIdItem();
		File pasta = new File(caminho);
		pasta.mkdir();
		
		//DirectoryStream <Path> diretorio = Files.newDirectoryStream(new File(servletContext.getRealPath("/") + "storage/Disciplinas/" + atividade.getDisciplina().getId() + "/" + atividade.getIdAtividade()).toPath());//
     	//for(Path path : diretorio){
     
          //}
		
		
		File convFile = new File( caminho +"/" + javafile.getOriginalFilename());
        try {
			javafile.transferTo(convFile);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return "redirect:/atividade/index/" + idAtividade;
	}

	
	
	
	
	int idItem;
	@RequestMapping(value ="/item/submissao/{idItem}", method = RequestMethod.GET)
	public String adicionarSubmissao(Model model, @PathVariable("idItem") int id ) {
		
		Item item = itemService.findById(id);
		model.addAttribute("item", item); 
		idItem = id;
		
		
		return "item/index_item"; //Aqui vai o nome da jsp
	}
	
	@RequestMapping(value = "/item/submissao", method = RequestMethod.POST)
	public String adicionarSubmissao(@RequestParam("idItem") int idItem, @RequestParam("javafile") MultipartFile javafile, HttpSession session ) throws IOException {
		Aluno aluno = (Aluno)session.getAttribute("usuarioLogado");
		Item item = itemService.findById(idItem);
		Atividade atividade = atividadeService.findById(item.getAtividade().getIdAtividade()); //Verificar se isso está correto
		
		String caminhoPai = servletContext.getRealPath("/") + "Storage/Disciplinas/" + atividade.getDisciplina().getId() + "/" + atividade.getIdAtividade() + "/" + item.getIdItem() + "/" + item.getCasoDeTeste();
		String caminho = servletContext.getRealPath("/") + "Storage/Disciplinas/" + atividade.getDisciplina().getId() + "/" + atividade.getIdAtividade() + "/" + item.getIdItem()+ "/" + aluno.getId();
		File pasta = new File(caminho);
		pasta.mkdir();
		
		DirectoryStream <Path> diretorio = Files.newDirectoryStream(new File(servletContext.getRealPath("/") + "storage/Disciplinas/" + atividade.getDisciplina().getId() + "/" + atividade.getIdAtividade()).toPath());//
        
		File convFile = new File( caminho +"/" + javafile.getOriginalFilename());
        try {
			javafile.transferTo(convFile);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String caminhofilho = caminho +"/" + javafile.getOriginalFilename();
		
		
      //O código abaixo é testando a avaliação
		ResultadoAvaliacao resultado = new ResultadoAvaliacao();
        String message = "";
        
		try {
			System.out.println("****************PAI: " + caminhoPai);
			System.out.println("****************FILHO: " + caminhofilho);
			System.out.println("*************NOVO ARQUIVO: " + caminho +"/" +item.getCasoDeTeste() );
			
			List<Associacao> associacoes = associacaoService.findByItem(item);
			
			resultado = Avalia.run(caminhoPai, caminhofilho, associacoes);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException | IOException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
			e.printStackTrace();
		}
		
		System.out.println("Sua nota foi: " + resultado.getNota());
		System.out.println("Mensagens: " + resultado.getMensagem());
		session.setAttribute("resultado", resultado);
		return "redirect:/item/resultado";
	}
		
	@RequestMapping(value = "/item/resultado")
	public String resultado() {
		

		return "item/resultado";
	}

	
	
	@RequestMapping(value = "/item/remover/{idItem}", method = RequestMethod.GET)
	public String remover(@PathVariable("idItem") int id) {
		itemService.remover(id);
		return "redirect:/item/index_item";
	}

	
	
	public void copiar(String origem, String destino) throws IOException{
		File src = new File(origem);
		File dst = new File(destino);
		InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);           // Transferindo bytes de entrada para saída
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
	}
	
	
}
