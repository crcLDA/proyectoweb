package com.proyectoweb.controller;

import com.proyectoweb.domain.Cliente;
import com.proyectoweb.domain.Profesionista;
import com.proyectoweb.domain.Usuario;
import com.proyectoweb.service.ClienteService;
import com.proyectoweb.service.ProfesionistaService;
import com.proyectoweb.service.RegistroService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ProfesionistaService profesionistaService;

    @GetMapping("/nuevo")
    public String nuevo(Model model, Usuario usuario) {
        return "/registro/nuevo";
    }

    @GetMapping("/recordar")
    public String recordar(Model model, Usuario usuario) {
        return "/registro/recordar";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(Model model, Usuario usuario) throws MessagingException {
        Cliente cliente = new Cliente();
        Profesionista profesionista = new Profesionista();
        cliente.setCedula(usuario.getCedula());
        clienteService.save(cliente);
        
        profesionista.setCliente(clienteService.getCliente(cliente.getCedula()));
        profesionistaService.save(profesionista);
        
        model = registroService.crearUsuario(model, usuario);
        return "/registro/salida";
    }

    @GetMapping("/activacion/{usuario}/{id}")
    public String activar(
            Model model, 
            @PathVariable(value = "usuario") String usuario, 
            @PathVariable(value = "id") String id) {
        model = registroService.activar(model, usuario, id);
        if (model.containsAttribute("usuario")) {
            return "/registro/activa";
        } else {
            return "/registro/salida";
        }
    }

    @PostMapping("/activar")
    public String activar(Usuario usuario) {
        registroService.activar(usuario);
        return "redirect:/";
    }

    @PostMapping("/recordarUsuario")
    public String recordarUsuario(Model model, Usuario usuario) 
            throws MessagingException {
        model = registroService.recordarUsuario(model, usuario);
        return "/registro/salida";
    }
}

