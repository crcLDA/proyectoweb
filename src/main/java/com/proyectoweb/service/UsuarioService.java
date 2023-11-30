
package com.proyectoweb.service;

import com.proyectoweb.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    public List<Usuario> getUsuarios();
    
    public Usuario getUsuario(Long idUsuario);
    
    public void save(Usuario usuario);
    
    public void delete(Usuario usuario);
    
    public boolean esAdmin(String cedula);
}
