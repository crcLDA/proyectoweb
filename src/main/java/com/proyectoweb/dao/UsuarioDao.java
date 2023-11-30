package com.proyectoweb.dao;

import com.proyectoweb.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDao extends JpaRepository <Usuario, String>{
    Usuario findByUsername(String username);
    
    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery=true,
            value="SELECT * FROM empleatewp.usuario WHERE username= :usuario AND password= :clave")
    public Usuario verificarLogin(@Param("usuario") String usuario, @Param("clave") String clave); 
    
    @Query(nativeQuery=true,
            value="SELECT u.* FROM usuario u JOIN rol r ON u.username = r.username WHERE u.cedula = :cedula AND r.nombre = 'ADMIN';")
    public Usuario esAdmin(@Param("cedula") String cedula); 
}