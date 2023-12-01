package com.proyectoweb.service;

import com.proyectoweb.domain.Rol;
import com.proyectoweb.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RolService {
    public List<Object[]> listaAdmins();
    
    public int contarAdmins();
    
    public void eliminarAdmin(String username);
    
    public void save(Rol rol);
}
