package com.proyectoweb.dao;

import com.proyectoweb.domain.Profesionista;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfesionistaDao extends JpaRepository <Profesionista, Long>{
    /*@Query(nativeQuery=true, value="SELECT C.cedula, C.ruta_imagen, CONCAT_WS(\" \", C.nombre, C.apellidos) AS nombre, P.ocupacion, P.activo " +
            "FROM empleatewp.cliente C, empleatewp.profesionista P " +
            "WHERE (P.cedula=C.cedula)")
    public List<perfilProfesional> getPerfiles();*/ 
    
    public Profesionista findByCedula(String cedula);
}
