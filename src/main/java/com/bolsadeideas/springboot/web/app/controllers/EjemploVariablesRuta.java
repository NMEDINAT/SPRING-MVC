package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRuta {
	
	@GetMapping({"/index","/"})
	public String index(Model model)
	{
		model.addAttribute("titulo","Enviar parametros de la ruta (@PathVariable)");
		return "variables/index";
	}

	@GetMapping("/string/{texto}")
	public ModelAndView variables(@PathVariable String texto , ModelAndView mv) {
		mv.addObject("titulo","Recibir parametros de la ruta (@PathVariable)");
		mv.addObject("resultado","El texto enviado en la ruta es : " + texto);
		mv.setViewName("variables/ver");
		return mv;
	}
	
	@GetMapping("/string/{texto}/{numero}") ModelAndView variables(@PathVariable String texto ,
			@PathVariable Integer numero , ModelAndView mv) {
		mv.addObject("titulo","Recibir parametros de la ruta (@PathVariable)");
		mv.addObject("resultado","El texto enviado en la ruta es : " + texto +" y el numero es : " + numero);
		mv.setViewName("variables/ver");
		return mv;
	}
	
	
}
