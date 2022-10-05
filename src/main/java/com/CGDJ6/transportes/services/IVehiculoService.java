package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.Usuario;
import com.CGDJ6.transportes.entities.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    public List<Vehiculo> listarVehiculo(String palabraClave);

    List<Vehiculo> listarVehiculos();

    public void guardarVehiculo(Vehiculo vehiculo);
    public void eliminarVehiculo(Vehiculo vehiculo);
    public Vehiculo encontrarVehiculo(Vehiculo vehiculo);
    public void eliminadoSuave(Vehiculo vehiculo);


}
