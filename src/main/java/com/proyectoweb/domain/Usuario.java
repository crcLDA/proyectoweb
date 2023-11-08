package com.proyectoweb.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario  implements Serializable{
    @Id
    private String username;
    
    private String password;
    private Long cedCliente;

    public Usuario() {}

    public Usuario(String username, String password, Long cedCliente) {
        this.username = username;
        this.password = password;
        this.cedCliente = cedCliente;
    }  
}
