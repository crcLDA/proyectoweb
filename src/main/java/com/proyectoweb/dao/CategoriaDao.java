package com.proyectoweb.dao;

import com.proyectoweb.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository <Categoria, Long>{}