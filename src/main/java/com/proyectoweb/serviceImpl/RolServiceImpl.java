package com.proyectoweb.serviceImpl;

import com.proyectoweb.dao.RolDao;
import com.proyectoweb.domain.Reporte;
import com.proyectoweb.domain.Rol;
import com.proyectoweb.service.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl   implements RolService{
    
    @Autowired
    private RolDao rolDao;
    
    @Override
    public List<Object[]> listaAdmins(){
        return rolDao.listaAdmins();
    }
    
    @Override
    public int contarAdmins(){
        return rolDao.contarAdmins();
    }
    
    @Override
    public void eliminarAdmin(String username){
        List<Rol> rolesAdmin = rolDao.findByUsernameAndNombre(username, "ADMIN");
        rolDao.deleteAll(rolesAdmin);
    }
    
    @Override
    @Transactional
    public void save(Rol rol) {
        rolDao.save(rol);
    }
}


