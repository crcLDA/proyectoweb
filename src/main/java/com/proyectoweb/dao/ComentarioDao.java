package com.proyectoweb.dao;

import com.proyectoweb.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioDao extends JpaRepository <Comentario, Long>{}