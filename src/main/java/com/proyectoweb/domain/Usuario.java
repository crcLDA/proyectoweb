package com.proyectoweb.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private String username;
    
    @NotEmpty
    private String password;
    
    @NotEmpty
    private Long cedula;
    
    @NotEmpty
    private String correo;
    
    @NotEmpty
    private boolean activo;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private List<Rol> roles;

    /*public Usuario() {}

    public Usuario(String username, String password, Long cedula, List<Rol> roles) {
        this.username = username;
        this.password = password;
        this.cedula = cedula;
        this.roles = roles;
    }*/

    
}
