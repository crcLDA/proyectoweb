package com.proyectoweb.controller;

import com.proyectoweb.domain.Comentario;
import com.proyectoweb.service.ComentarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;
    
    @PostMapping("/guardar")
    public String comentarioGuardar(Comentario comentario) {
        comentarioService.save(comentario);
        return "redirect:/profesionista/listado";
    }
    
    
    @GetMapping("/modificar/{idComentario}")
    public String modificarPerfil(Model model, HttpSession session, Comentario comentario) {
        System.out.println("*******************************************");
        System.out.println(comentario.getOpinion());
        System.out.println(comentario.getIdComentario());
        //comentarioService.save(comentario);
        return "redirect:/profesionista/listado";
    }
    
    @GetMapping("/eliminar/{idComentario}")
    public String categoriaEliminar(Comentario comentario) {
        comentarioService.delete(comentario);
        return "redirect:/profesionista/listado";
    }
}
