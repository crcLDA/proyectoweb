package com.proyectoweb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    @Column(name="id_profesionista")
    private Long idProfesionista;
    
    /*@Column(name="cedula")
    private String cedula;*/
    
    private String ocupacion;
    private String correo;
    private String telefono;
    private String instagram;
    private String descripcion;
    //private int idCategoria;
    private boolean activo;
    
    //insetable, updatable
    @OneToOne
    @JoinColumn(name="cedula")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")//este es de esta tabla
    private Categoria categoria;

    public Profesionista() {}

    public Profesionista(String ocupacion, String correo, String telefono, String instagram, String descripcion, boolean activo, Cliente cliente, Categoria categoria) {
        this.ocupacion = ocupacion;
        this.correo = correo;
        this.telefono = telefono;
        this.instagram = instagram;
        this.descripcion = descripcion;
        this.activo = activo;
        this.cliente = cliente;
        this.categoria = categoria;
    }

    
    
    
    
}
