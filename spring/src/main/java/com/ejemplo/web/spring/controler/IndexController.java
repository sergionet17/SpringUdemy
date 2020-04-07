package com.ejemplo.web.spring.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ejemplo.web.spring.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value ("${texto.propiedad.index}")
	private String textoIndex;
	@Value ("${texto.propiedad.perfil}")
	private String textoPerfil;
	@Value ("${texto.propiedad.listar}")
	private String textoListar;
	

	@RequestMapping(value = {"/index","/home"},method=RequestMethod.GET)
	public String index(Model model) {
		
		model.addAttribute("titulo","xtoIndexSpringFramework");
		
		return "index";
	}
	
	@RequestMapping(value="/perfil")
	public String perfil (Model model){
		
		Usuario usuario = new Usuario();
		usuario.setApellido("Sanchez");
		usuario.setNombre("Camilo");
		usuario.setEmail("estefue@queleimposrtaaaa.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo","SpringFramework".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping(value="/listar")
	public String listar (Model model){
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("pruebaaa","FUE","primero"));
		usuarios.add(new Usuario("QUE","SE","DICE COREO"));
		usuarios.add(new Usuario("tercero nombre","tercero apellido","tercero mail"));
		usuarios.add(new Usuario("bueno","mi","papa"));
		
		model.addAttribute("titulo", textoListar);
		
		//model.addAttribute("usuarios",usuarios);
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("COMO","FUE","correoFUE"),
				new Usuario("QUE","SE","DICE COREO"),
				new Usuario("tercero nombre","tercero apellido","tercero mail"),
				new Usuario("BuenoMiPapa","cuartetoconuncuarteto","sinpalabras")
				);
		
		return usuarios;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
