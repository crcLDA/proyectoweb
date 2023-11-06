package com.proyectoweb.serviceImpl;

import com.proyectoweb.dao.ReporteDao;
import com.proyectoweb.domain.Reporte;
import com.proyectoweb.service.ReporteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReporteServiceImpl implements ReporteService{
    
    @Autowired
    private ReporteDao reporteDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Reporte> getReportes() {
        List<Reporte> reportes = reporteDao.findAll();
        
        return reportes;
    }

    @Override
    public Reporte getReporte(Reporte reporte) {
        return reporteDao.findById(reporte.getId()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Reporte reporte) {
        reporteDao.save(reporte);
    }

    @Override
    @Transactional
    public void delete(Reporte reporte) {
        reporteDao.delete(reporte);
    }
}