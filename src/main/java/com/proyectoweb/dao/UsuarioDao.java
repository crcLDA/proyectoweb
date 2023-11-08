package com.proyectoweb.dao;

import com.proyectoweb.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository <Usuario, String>{}
