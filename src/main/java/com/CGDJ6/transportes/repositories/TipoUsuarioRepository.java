package com.CGDJ6.transportes.repositories;

import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
        /*@Query("select e.activo, from TipoUsuario e")
    public List<TipoUsuario> buscarSuave(Long palabraClave);*/



}
