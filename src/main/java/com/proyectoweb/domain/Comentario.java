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
@Table(name="comentario")
public class Comentario  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String idProfesionista;
    private String opinion;

    public Comentario() {}

    
    
    public Comentario(Long id, String idProfesionista, String opinion) {
        this.id = id;
        this.idProfesionista = idProfesionista;
        this.opinion = opinion;
    }
    
    
}
