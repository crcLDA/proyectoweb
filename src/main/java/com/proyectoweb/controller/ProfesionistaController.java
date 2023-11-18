package com.proyectoweb.controller;

import com.proyectoweb.domain.Categoria;
import com.proyectoweb.domain.Profesionista;
import com.proyectoweb.service.CategoriaService;
import com.proyectoweb.service.ClienteService;
import com.proyectoweb.service.ProfesionistaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("/profesionista")
@Controller
public class ProfesionistaController {
    
    @Autowired
    private ProfesionistaService profesionistaService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Profesionista> listadoProfesionistas = profesionistaService.getProfesionistas(true);
        model.addAttribute("profesionistas", listadoProfesionistas);
        return "/profesionistas/listado";
    }
    
    @GetMapping("/verPerfil/{cedula}")
    public String verPerfil(Profesionista profesionista, Model model) {
        profesionista = profesionistaService.findByCedula(profesionista.getCedula());
        List<Categoria> listadoCategorias = categoriaService.getCategorias(true);
        model.addAttribute("profesionista", profesionista);
        model.addAttribute("categorias", listadoCategorias);
        return "/profesionistas/perfil";
    }
   
    @PostMapping("/guardar")
    public String profesionistaGuardar(Profesionista profesionista) {        
        profesionistaService.save(profesionista);
        return "redirect:/profesionista/listado";
    }
}
