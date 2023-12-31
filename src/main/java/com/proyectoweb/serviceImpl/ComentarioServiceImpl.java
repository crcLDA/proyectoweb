package com.proyectoweb.serviceImpl;

import com.proyectoweb.dao.ComentarioDao;
import com.proyectoweb.domain.Comentario;
import com.proyectoweb.service.ComentarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioServiceImpl implements ComentarioService{
    @Autowired
    private ComentarioDao comentarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Comentario> getComentarios() {
        List<Comentario> comentarios = comentarioDao.findAll();
        return comentarios;
    }

    @Override
    @Transactional(readOnly=true)
    public Comentario getComentario(Comentario comentario) {
        return comentarioDao.findById(comentario.getIdComentario()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Comentario comentario) {
        comentarioDao.save(comentario);
    }

    @Override
    @Transactional
    public void delete(Comentario comentario) {
        comentarioDao.delete(comentario);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Comentario> findByIdProfesionista(Long idProfesionista){
        return comentarioDao.findByIdProfesionista(idProfesionista);
    }
}
