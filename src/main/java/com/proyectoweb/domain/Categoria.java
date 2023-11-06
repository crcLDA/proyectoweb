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
@Table(name="categoria")
public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String descripcion;
    private boolean activo;

    public Categoria() {}

    public Categoria(Long id, String descripcion, boolean activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
    }
}
