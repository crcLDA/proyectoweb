package com.proyectoweb.serviceImpl;

import com.proyectoweb.dao.UsuarioDao;
import com.proyectoweb.domain.Rol;
import com.proyectoweb.domain.Usuario;
import com.proyectoweb.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserDetailsService")
public class UsuarioServiceImpl  implements UsuarioService, UserDetailsService{
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly=true)
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = usuarioDao.findAll();
        
        return usuarios;
    }

    /*@Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getUsername()).orElse(null);
    }*/
    
    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public Long validar(String usuario, String clave) {
        Usuario us = usuarioDao.verificarLogin(usuario, clave);
        if (us!=null){
            return us.getCedula();      
        }else return Long.parseLong("0");
    }
    
    @Override
    @Transactional(readOnly=true)
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //busca el usuario en la BD
        Usuario usuario = usuarioDao.findByUsername(username);
        
        //sino existe lanza una excepcion
        if (usuario==null) throw new UsernameNotFoundException(username);
        
        //se encontro usuario en BD y se remueve el atributo en la sesion
        /*session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());*/
        //session.removeAttribute("cedula");
        session.setAttribute("cedula", usuario.getCedula());
        var roles = new ArrayList<GrantedAuthority>();
        
        //se transforma los roles a granted authority
        for (Rol item : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(item.getNombre()));
        }
        
        //retorna el User (clase details)
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
}
