package com.CGDJ6.transportes.repositories;

import com.CGDJ6.transportes.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo,String> {

    @Query("SELECT v FROM  Vehiculo v WHERE CONCAT(v.placa,v.marca,v.modelo,v.tipoVehiculo) LIKE %?1%")
    public List<Vehiculo> findAll(String palabraClave);




//    @Query("SELECT v FROM  Vehiculo v WHERE CONCAT()LIKE %?1%")
//    public List<Vehiculo> findAll(String palabraClave);

}


//OR v.marca LIKE %?1%