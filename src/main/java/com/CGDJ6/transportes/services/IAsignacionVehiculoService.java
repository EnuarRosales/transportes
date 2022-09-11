package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.AsignacionVehiculo;

import java.util.List;

public interface IAsignacionVehiculoService {

    public List<AsignacionVehiculo> listarAsignacionVehiculo ();
    public void guardarAsignacionVehiculo(AsignacionVehiculo  asignacionVehiculo);
    public void eliminarAsignacionVehiculo(AsignacionVehiculo  asignacionVehiculo);
    public AsignacionVehiculo encontrarAsignacionVehiculo(AsignacionVehiculo asignacionVehiculo);
}
