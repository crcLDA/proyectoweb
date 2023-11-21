package com.proyectoweb.controller;

import com.proyectoweb.dao.ClienteDao;
import com.proyectoweb.domain.Cliente;
import com.proyectoweb.domain.Profesionista;
import com.proyectoweb.service.CategoriaService;
import com.proyectoweb.service.ClienteService;
import com.proyectoweb.service.ProfesionistaService;
import com.proyectoweb.serviceImpl.FirebaseStorageServiceImpl;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    /*@GetMapping("/perfil")
    public String inicio(Model model) {
        Cliente cliente = clienteDao.findById(Long.parseLong("123")).orElse(null);
        model.addAttribute("cliente", cliente);
        return "/clientes/perfil";
    }*/
    
    @GetMapping("/modificarPerfil/{cedula}")
    public String modificarPerfil(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente.getCedula());
        model.addAttribute("cliente", cliente);
        System.out.println(cliente.getRutaImagen());
        return "/clientes/modificar";
    }
    
    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            clienteService.save(cliente);
            cliente.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "cliente", 
                            cliente.getCedula()));
        }
        clienteService.save(cliente);
        return "redirect:/profesionista/listado";
    }
}
