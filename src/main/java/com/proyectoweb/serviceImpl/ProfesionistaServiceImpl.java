package com.proyectoweb.serviceImpl;

import com.proyectoweb.dao.ProfesionistaDao;
import com.proyectoweb.domain.Profesionista;
import com.proyectoweb.service.ProfesionistaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesionistaServiceImpl implements ProfesionistaService{
    @Autowired
    private ProfesionistaDao profesionistaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Profesionista> getProfesionistas(boolean activos) {
        List<Profesionista> profesionistas = profesionistaDao.findAll();
        
        if (activos){
            profesionistas.removeIf(c -> !c.isActivo());
        }
        
        return profesionistas;
    }

    @Override
    public Profesionista getProfesionista(Long idProfesionista) {
        return profesionistaDao.findById(idProfesionista).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Profesionista profesionista) {
        profesionistaDao.save(profesionista);
    }

    @Override
    @Transactional
    public void delete(Profesionista profesionista) {
        profesionistaDao.delete(profesionista);
    }
    
    @Override
    public Profesionista fingByCedula(Long cedula){
        return profesionistaDao.findByCedula(cedula);
    }
    
    @Override
    public List<Profesionista> filtroOcupacion(String filtroOcupacion) {
        System.out.println(filtroOcupacion);
        return profesionistaDao.filtroOcupacion(filtroOcupacion);
    } 
}
