package com.proyectoweb.serviceImpl;

import com.proyectoweb.dao.RolDao;
import com.proyectoweb.dao.UsuarioDao;
import com.proyectoweb.domain.Rol;
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
    
    @Autowired
    private RolDao rolDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = usuarioDao.findAll();

        return usuarios;
    }

    @Override
    public Usuario getUsuario(Long idUsuario) {
        return usuarioDao.findById(idUsuario+"").orElse(null);
    }


    @Override
    public boolean esAdmin(String cedula) {
        Usuario u = usuarioDao.esAdmin(cedula);
        return u != null;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(Usuario usuario, boolean crearRolUser) {
        usuario=usuarioDao.save(usuario);
        if (crearRolUser) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombre("ROLE_USER");
            rol.setUsername(usuario.getUsername());
            rolDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
