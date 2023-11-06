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
@Table(name="cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long cedula;
    
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private int annoNacimiento;
    private int mesNacimiento;
    private int diaNacimiento;
    private String rutaImagen;
    private boolean esAdmin;
    private boolean activo;

    public Cliente() {}

    public Cliente(Long cedula, String username, String password, String nombre, String apellidos, String correo, String telefono, int annoNacimiento, int mesNacimiento, int diaNacimiento, String rutaImagen, boolean esAdmin, boolean activo) {
        this.cedula = cedula;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.annoNacimiento = annoNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.diaNacimiento = diaNacimiento;
        this.rutaImagen = rutaImagen;
        this.esAdmin = esAdmin;
        this.activo = activo;
    }
    
    
}
