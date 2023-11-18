package com.proyectoweb.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity 
@Table(name="categoria")
public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Column(name = "id_categoria")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCategoria;
    
    private String descripcion;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name="id_categoria", insertable=false, updatable=false)
    List<Profesionista> profesionistas;

    public Categoria() {}

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}
