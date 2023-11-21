package com.proyectoweb.dao;

import com.proyectoweb.domain.Comentario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioDao extends JpaRepository <Comentario, Long>{
    public List<Comentario> findByIdProfesionista(Long idProfesionista);
}