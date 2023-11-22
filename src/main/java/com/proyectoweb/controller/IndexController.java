package com.proyectoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectoweb.service.UsuarioDetailsService;


@Controller
public class IndexController {
    @Autowired
    private UsuarioDetailsService usuarioService;
    
    @RequestMapping("/")
    public String page(Model model) {
        if (model.containsAttribute("cedula")){
            return "/profesionistas/listado";
        }
        return "index";
    }
    
    
    /*@RequestMapping("/login")
    public String login(@RequestParam(value = "usuario") String usuario,
            @RequestParam(value = "clave") String clave, Model model) {
        Long ced = usuarioService.validar(usuario, clave);
        model.addAttribute("cedula", ced);
        if (ced>0) return "/profesionistas/listado";
        else return "index";
        
    }*/
    
}
