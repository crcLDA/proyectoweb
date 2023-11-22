package com.proyectoweb.service;

import com.proyectoweb.domain.Usuario;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService {
    /*public List<Usuario> getUsuarios();
    
    public void save(Usuario usuario);
    
    public void delete(Usuario usuario);
    
    public Long validar(String usuario, String clave);*/
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
    public Usuario getUsuarioPorUsername(String username);
}
