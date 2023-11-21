package com.proyectoweb.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="comentario")
public class Comentario  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idComentario;
    private Long idProfesionista;
    private Long cedula;
    private String opinion;
    
    
    /*@OneToMany
    @JoinColumn(name="id_profesionista", insertable=false, updatable=false)
    List<Profesionista> profesionistas;
    
    @OneToMany
    @JoinColumn(name="cedula")
    List<Cliente> clientes;*/

    public Comentario() {}

    
}
