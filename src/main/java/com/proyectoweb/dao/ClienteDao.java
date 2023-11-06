package com.proyectoweb.dao;

import com.proyectoweb.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao  extends JpaRepository <Cliente, String>{}