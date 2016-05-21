package br.ufc.quixada.javaliproject.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.quixada.javaliproject.evaluationservice.Runner;
import br.ufc.quixada.javaliproject.model.Disciplina;
import br.ufc.quixada.javaliproject.service.DisciplinaService;

@Controller
public class RunnerController {
	
	
	@RequestMapping(value = "/runner")
	public String index(Model model) {

		model.addAttribute("message","");
		return "runner";
	}
	
	@RequestMapping(value = "/runner/run")
	public String run(Model model) {
		String message = "";
		try {
			message = Runner.runClass().toString();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException | IOException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("message",message);
		
		return "runner";
	}
	
	
	
	
	
}
