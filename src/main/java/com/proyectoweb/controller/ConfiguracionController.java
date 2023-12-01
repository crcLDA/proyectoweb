/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.proyectoweb.controller;

import com.proyectoweb.domain.Categoria;
import com.proyectoweb.domain.Cliente;
import com.proyectoweb.domain.Reporte;
import com.proyectoweb.domain.Rol;
import com.proyectoweb.service.CategoriaService;
import com.proyectoweb.service.ReporteService;
import com.proyectoweb.service.RolService;
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

@Controller
@RequestMapping("/configuracion")
public class ConfiguracionController {
    
    @Autowired
    private ReporteService reporteService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private RolService rolService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    private boolean esAdmin(HttpSession session){
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        return usuarioService.esAdmin(cliente.getCedula()+"");
    }
    
    
    @RequestMapping("/")
    public String configuracion(Model model, HttpSession session) {
        Reporte reporte = new Reporte();

        model.addAttribute("reporte", reporte);
        model.addAttribute("mostrarVista", esAdmin(session));
        
        return "/settings/configuracion";

    }
    
    @RequestMapping("/guardarReporte")
    public String nuevoReporte(Reporte reporte) {
        reporteService.save(reporte);
        return "/settings/configuracion";
    }
    
    @GetMapping("/listadoReportes")
    public String listadoReportes(Model model, HttpSession session) {
        List<Reporte> listadoReportes = reporteService.getReportes();
        model.addAttribute("reportes", listadoReportes);
        model.addAttribute("totalReportes", listadoReportes.size());
        model.addAttribute("mostrarVista", esAdmin(session));
        
        if (esAdmin(session)) return "/settings/listadoReportes";
        else return "/settings/configuracion";
    }
    
    @GetMapping("/eliminarReporte/{idReporte}")
    public String categoriaEliminar(Reporte reporte, HttpSession session) {
        if (esAdmin(session)) reporteService.delete(reporte);
        return "redirect:/configuracion/listadoReportes";
    }
    
    @GetMapping("/listadoCuentas")
    public String listadoCuentas(Model model, HttpSession session) {
        var listadoCuentas = rolService.listaAdmins();
        model.addAttribute("cuentas", listadoCuentas);
        model.addAttribute("mostrarVista", esAdmin(session));
        if (esAdmin(session)) return "/settings/listadoCuentas";
        else return "/settings/configuracion";
        
    }
    
    @GetMapping("/ponerAdmin/{username}")
    public String ponerAdmin(Model model, @PathVariable String username, HttpSession session) {
        Rol rol = new Rol();
        rol.setIdRol(null);
        rol.setNombre("ADMIN");
        rol.setUsername(username);
        
        if (esAdmin(session)) {
            rolService.save(rol);
            return "redirect:/configuracion/listadoCuentas";
        }
        else return "/settings/configuracion";
    }
    
    @GetMapping("/quitarAdmin/{username}")
    public String quitarAdmin(Model model, @PathVariable String username, HttpSession session) {
        if (esAdmin(session)) {
            if (rolService.contarAdmins()>1){
                rolService.eliminarAdmin(username);
            }
            return "redirect:/configuracion/listadoCuentas";
        }
        else return "/settings/configuracion"; 
    }
    
    @GetMapping("/listadoCategorias")
    public String listadoCategorias(Model model, HttpSession session) {
        List<Categoria> listadoCategorias = categoriaService.getCategorias(false);

        model.addAttribute("mostrarVista", esAdmin(session));
        model.addAttribute("categorias", listadoCategorias);
        model.addAttribute("totalCategorias", listadoCategorias.size());
        
        if (esAdmin(session)) return "/settings/listadoCategorias";
        else return "/settings/configuracion";
    }

    @GetMapping("/nuevaCategoria")
    public String categoriaNuevo(Categoria categoria) {
        return "/configuracion/modificaCategoria";
    }

    @PostMapping("/guardarCategoria")
    public String categoriaGuardar(Categoria categoria) {        
        categoriaService.save(categoria);
        return "redirect:/configuracion/listadoCategorias";
    }

    @GetMapping("/eliminarCategoria/{idCategoria}")
    public String categoriaEliminar(Categoria categoria, HttpSession session) {
        if (esAdmin(session)) {
            categoriaService.delete(categoria);
            return "redirect:/configuracion/listadoCategorias";
        }
        else return "/settings/configuracion";
    }

    @GetMapping("/modificarCategoria/{idCategoria}")
    public String categoriaModificar(Categoria categoria, Model model,HttpSession session) {
        if (esAdmin(session)) {
            categoria = categoriaService.getCategoria(categoria);
            model.addAttribute("categoria", categoria);
            return "/settings/modificaCategoria";
        }
        else return "/settings/configuracion";
    }
}
