package com.proyectoweb.controller;

import com.proyectoweb.dao.ClienteDao;
import com.proyectoweb.domain.Categoria;
import com.proyectoweb.domain.Cliente;
import com.proyectoweb.domain.Comentario;
import com.proyectoweb.domain.Profesionista;
import com.proyectoweb.service.CategoriaService;
import com.proyectoweb.service.ClienteService;
import com.proyectoweb.service.ComentarioService;
import com.proyectoweb.service.ProfesionistaService;
import com.proyectoweb.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("/profesionista")
@Controller
public class ProfesionistaController {
    /***************************************************************/
    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private HttpSession session;
    /***************************************************************/
    
    @Autowired
    private ProfesionistaService profesionistaService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ComentarioService comentarioService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Profesionista> listadoProfesionistas = profesionistaService.getProfesionistas(true);
        model.addAttribute("profesionistas", listadoProfesionistas);
        return "/profesionistas/listado";
    }
    
    @GetMapping("/verPerfil/{idProfesionista}")
    public String verPerfil(Profesionista profesionista, Model model, HttpSession session) {
        profesionista = profesionistaService.getProfesionista(profesionista.getIdProfesionista());
        var comentarios = comentarioService.findByIdProfesionista(profesionista.getIdProfesionista());
        Cliente cliente;
        
        for(Comentario item:comentarios) {
            cliente = clienteDao.findById(item.getCedula()).orElse(null);
            item.setOpinion(cliente.getNombre() + " " + cliente.getApellidos() + ":" + item.getOpinion());
        }
        
        cliente = (Cliente) session.getAttribute("cliente");
        Comentario comentario = new Comentario(); 
        comentario.setCedula(cliente.getCedula());
        comentario.setIdProfesionista(profesionista.getIdProfesionista());
        model.addAttribute("mostrarVista", usuarioService.esAdmin(cliente.getCedula()+""));
        model.addAttribute("profesionista", profesionista);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("comentario", comentario);
        return "/profesionistas/perfil";
    }
    
    @GetMapping("/modificarPerfil/{cedula}")
    public String modificarPerfil(@PathVariable String cedula, Model model, HttpSession session) {
        // Obtener el cliente de la sesión o cargarlo desde el servicio si no existe
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            cliente = clienteService.getCliente(Long.parseLong(cedula));
            session.setAttribute("cliente", cliente);
        }

        Profesionista profesionista = profesionistaService.fingByCedula(cliente.getCedula());
        List<Categoria> listadoCategorias = categoriaService.getCategorias(true);

        model.addAttribute("profesionista", profesionista);
        model.addAttribute("categorias", listadoCategorias);

        if (Long.parseLong(cedula)==cliente.getCedula()){
            return "/profesionistas/modificar";
        } ///mostrar vista de listado
        else{
            return "redirect:/profesionista/listado";
        }
    }
   
    @PostMapping("/guardar")
    public String profesionistaGuardar(Profesionista profesionista) {        
        profesionistaService.save(profesionista);
        return "redirect:/profesionista/listado";
    }
    
    @PostMapping("/buscarOcupacion")
    public String consultaQuery3(@RequestParam(value = "filtroOcupacion") String ocupacion, Model model) {
        /*var productos = productoService.filtroOcupacion(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("filtroOcupacion", ocupacion);*/
        
        /*Cliente cliente = clienteDao.findById(Long.parseLong("123")).orElse(null);
        session.setAttribute("cliente", cliente);*/
        var listadoProfesionistas = profesionistaService.filtroOcupacion(ocupacion);
        model.addAttribute("profesionistas", listadoProfesionistas);
        model.addAttribute("filtroOcupacion", ocupacion);
        return "/profesionistas/listado";
        
        /*List<Profesionista> listadoProfesionistas = profesionistaService.getProfesionistas(true);
        model.addAttribute("profesionistas", listadoProfesionistas);
        return "/profesionistas/listado";*/
    }
}
