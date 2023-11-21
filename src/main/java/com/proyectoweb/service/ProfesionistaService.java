package com.proyectoweb.service;

import com.proyectoweb.domain.Profesionista;
import java.util.List;

public interface ProfesionistaService {
    public List<Profesionista> getProfesionistas(boolean activos);
    
    public Profesionista getProfesionista(Long idProfesionista);
    
    public void save(Profesionista profesionista);
    
    public void delete(Profesionista profesionista);
    
    public Profesionista fingByCedula(Long cedula);
    
    public List<Profesionista> filtroOcupacion(String filtroOcupacion);
}
