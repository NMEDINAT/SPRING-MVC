package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	//@RequestMapping(value = "/index",method = RequestMethod.GET)
	//@GetMapping
	//@PostMapping
/*	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo","Hola Spring Framework");
		return "index.html";
	}  */
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	
	@GetMapping({"/index","/","/home"})
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo",textoIndex);
		mv.setViewName("index");
		return mv;
	}
	
	
	@RequestMapping("/perfil")
	public ModelAndView perfil(ModelAndView mv)
	{
		Usuario u = new Usuario();
		u.setNombre("Nestor");
		u.setApellido("Medina Tanco");
		u.setEmail("nestor_prog2018@outlook.com");
		mv.addObject("titulo","Perfil del usuario " .concat(u.getNombre()));
		mv.addObject("usuario",u);
		mv.setViewName("perfil");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listar(ModelAndView mv)
	{
		
		mv.addObject("titulo","Listado de usuarios ");
		//mv.addObject("usuarios",usuarios);
		mv.setViewName("listar");
		return mv;
	}
	
	
	@ModelAttribute("usuarios") //solo utilizar cuando lo queremos ver en varias vistas del controlador
	public List<Usuario> poblarUsuarios()
	{
		List<Usuario> usuarios = new ArrayList();
		Usuario u1 = new Usuario("Nestor","Medina","25km@gmail.com");
		Usuario u2 = new Usuario("Veali","Flores :(","carveli@gmail.com");
		usuarios.add(u1);
		usuarios.add(u2);
		return usuarios;
	}

	
	
	
	
	
	

	
	
}
