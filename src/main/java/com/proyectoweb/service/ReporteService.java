package com.proyectoweb.service;

import com.proyectoweb.domain.Reporte;
import java.util.List;

public interface ReporteService {
    public List<Reporte> getReportes();
    
    public Reporte getReporte(Reporte reporte);
    
    public void save(Reporte reporte);
    
    public void delete(Reporte reporte);
}
