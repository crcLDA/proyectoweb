package com.proyectoweb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="profesionista")
public class Profesionista implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String cedula;
    private String ocupacion;
    private String correo;
    private String telefono;
    private String instagram;
    private String descripcion;
    private int idCategoria;
    private boolean activo;

    public Profesionista() {}

    public Profesionista(Long id, String cedula, String ocupacion, String correo, String telefono, String instagram, String descripcion, int idCategoria, boolean activo) {
        this.id = id;
        this.cedula = cedula;
        this.ocupacion = ocupacion;
        this.correo = correo;
        this.telefono = telefono;
        this.instagram = instagram;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.activo = activo;
    }
    
    
    
}
