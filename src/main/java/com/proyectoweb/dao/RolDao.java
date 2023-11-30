package com.proyectoweb.dao;

import com.proyectoweb.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RolDao extends JpaRepository <Rol, Long> {
    
}
