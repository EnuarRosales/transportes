package com.CGDJ6.transportes.repositories;

import com.CGDJ6.transportes.entities.ServicioRealizado;
import com.CGDJ6.transportes.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicioRealizadoRepository extends JpaRepository<ServicioRealizado,Long> {
    @Query("SELECT s FROM  ServicioRealizado s WHERE CONCAT(s.tipoServicio,s.vehiculo,s.fechaInicioServicio,s.fechaTerminoServicio,s.kilometrajeInicio,s.descripcion) LIKE %?1%")
    public List<ServicioRealizado> findAll(String palabraClave);
}
