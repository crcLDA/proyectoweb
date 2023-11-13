package com.proyectoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfesionistaController {
    
    @RequestMapping("/profesionistas/listado")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "/profesionistas/listado";
    }
    
}
