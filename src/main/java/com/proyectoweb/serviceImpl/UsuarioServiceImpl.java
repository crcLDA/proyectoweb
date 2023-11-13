package com.proyectoweb.serviceImpl;

import com.proyectoweb.dao.UsuarioDao;
import com.proyectoweb.domain.Usuario;
import com.proyectoweb.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl  implements UsuarioService{
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = usuarioDao.findAll();
        
        return usuarios;
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getUsername()).orElse(null);
    }
    
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
            return us.getCedCliente();      
        }else return Long.parseLong("0");
    }
    
}
