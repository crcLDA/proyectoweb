package com.proyectoweb.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long cedula;

    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String fechaNacimiento;
    private String rutaImagen;
    private boolean activo;
    
    @OneToOne
    @JoinColumn(name="cedula", insertable=false, updatable=false)
    private Profesionista profesionista;

    public Cliente() {}

    public Cliente(Long cedula, String nombre, String apellidos, String correo, String telefono, String fechaNacimiento, String rutaImagen, boolean activo, Profesionista profesionista) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        this.profesionista = profesionista;
    }

    
    
    
}
