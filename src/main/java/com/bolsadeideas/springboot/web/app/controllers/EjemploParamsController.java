package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/string")
	public ModelAndView param(@RequestParam(defaultValue = "Algun valor") String texto , ModelAndView mv)
	{
		mv.addObject("resultado", "El parametro enviado es : " + texto);
		mv.setViewName("params/ver");
		return mv;
	}
	
	@GetMapping("/mix-params")
	public ModelAndView param(@RequestParam String saludo , @RequestParam Integer numero, ModelAndView mv)
	{
		mv.addObject("resultado", "El saludo enviado es : '" + saludo+"' y "
				+ " el numero es : '"+numero+"'");
		mv.setViewName("params/ver");
		return mv;
	}
	
	
	@GetMapping("/mix-params-request")
	public ModelAndView param(HttpServletRequest request,ModelAndView mv){
		String saludo=request.getParameter("saludo");
		Integer numero = null;
		try {
			numero=Integer.parseInt(request.getParameter("numero"));
		} catch (Exception e) {
			numero=0;
		}
		mv.addObject("resultado", "El saludo enviado es : '" + saludo+"' y "
				+ " el numero es : '"+numero+"'");
		
		mv.setViewName("params/ver");
		return mv;
	}
	
	
	@GetMapping("/")
	public ModelAndView index(ModelAndView mv)
	{
		mv.setViewName("params/index");
		return mv;
	}
	
	
	
	
	
	
	
	
	
}
