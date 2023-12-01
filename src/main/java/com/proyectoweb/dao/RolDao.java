package com.proyectoweb.dao;

import com.proyectoweb.domain.Rol;
import com.proyectoweb.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RolDao extends JpaRepository <Rol, Long> {
    @Query(nativeQuery=true,
            value="SELECT U.username, CONCAT_WS(' ', C.nombre, C.apellidos) AS nombre, " +
            "(SELECT EXISTS (SELECT 1 FROM rol R WHERE U.username = R.username AND R.nombre = 'ADMIN')) AS esAdmin " +
            "FROM cliente C, usuario U WHERE (U.cedula=C.cedula);")
    public List<Object[]> listaAdmins();
    
    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM Rol r WHERE r.nombre = 'ADMIN'")
    public int contarAdmins();
    
    public List<Rol> findByUsernameAndNombre(String username, String nombre);
    
    public void deleteByUsernameAndNombre(String username, String nombre);
}
