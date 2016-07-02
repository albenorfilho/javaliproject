package br.ufc.quixada.javaliproject.controller;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.quixada.javaliproject.evaluationservice.Runner;
import br.ufc.quixada.javaliproject.evaluationservice.teste;

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
			//message = Runner.runClass().toString();
			message = teste.test().toString();
		} catch (SecurityException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("message",message);
		
		return "runner";
	}
	
	
	
	
	
}
