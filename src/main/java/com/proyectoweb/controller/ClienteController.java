package com.proyectoweb.controller;


import com.proyectoweb.domain.Cliente;
import com.proyectoweb.domain.Profesionista;
import com.proyectoweb.service.ClienteService;
import com.proyectoweb.serviceImpl.FirebaseStorageServiceImpl;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    
    /*@GetMapping("/modificarPerfil/{cedula}")
    public String modificarPerfil(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente.getCedula());
        model.addAttribute("cliente", cliente);
        System.out.println(cliente.getRutaImagen());
        return "/clientes/modificar";
    }*/
    
    @GetMapping("/modificarPerfil/{cedula}")
    public String modificarPerfil(@PathVariable String cedula, Model model, HttpSession session) {
        // Obtener el cliente de la sesión o cargarlo desde el servicio si no existe
        Cliente clienteSession = (Cliente) session.getAttribute("cliente");
        Cliente clienteParam = (Cliente) clienteService.getCliente(Long.parseLong(cedula));
        if (Objects.equals(clienteParam.getCedula(), clienteSession.getCedula())) {
            session.setAttribute("cliente", clienteParam);
            model.addAttribute("cliente", clienteParam);
            return "/clientes/modificar";
        } else {
            return "redirect:/profesionista/listado";
        }
    }
    
    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente,
            @RequestParam("imagenFile") MultipartFile imagenFile) {      
        
        System.out.println(cliente);
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
