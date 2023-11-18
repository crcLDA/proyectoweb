package com.proyectoweb.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario  implements Serializable{
    @Id
    private String username;
    
    private String password;
    private Long cedula;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private List<Rol> roles;

    public Usuario() {}

    public Usuario(String username, String password, Long cedula, List<Rol> roles) {
        this.username = username;
        this.password = password;
        this.cedula = cedula;
        this.roles = roles;
    }

    
}
