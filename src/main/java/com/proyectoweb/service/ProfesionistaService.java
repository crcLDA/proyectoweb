package com.proyectoweb.service;

import com.proyectoweb.domain.Profesionista;
import java.util.List;

public interface ProfesionistaService {
    public List<Profesionista> getProfesionistas(boolean activos);
    
    public Profesionista getProfesionista(Profesionista profesionista);
    
    public void save(Profesionista profesionista);
    
    public void delete(Profesionista profesionista);
}
