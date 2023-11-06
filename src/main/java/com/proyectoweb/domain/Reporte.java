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
@Table(name="reporte")
public class Reporte  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String descripcion;

    public Reporte() {}

    public Reporte(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
}
