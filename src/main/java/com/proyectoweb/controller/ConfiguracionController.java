/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyectoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author antho
 */
@Controller
@RequestMapping("/configuracion")
public class ConfiguracionController {
    
    @RequestMapping("/")
    public String configuracion(Model model) {
        
        return "/settings/configuracion";
    }
    
}
