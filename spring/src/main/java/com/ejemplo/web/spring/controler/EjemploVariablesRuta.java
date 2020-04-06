package com.ejemplo.web.spring.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/variables")
public class EjemploVariablesRuta {

    @GetMapping("/string/{texto}")
    public String variables (@PathVariable String texto, Model model)
    {   
        model.addAttribute("tittle","recivir parametros del ruta");
        model.addAttribute("resultado", "el texto es @texto" + texto);
        return "variables/ver";
    }




}