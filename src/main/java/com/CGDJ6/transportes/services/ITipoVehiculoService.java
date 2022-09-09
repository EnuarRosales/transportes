package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.entities.TipoVehiculo;

import java.util.List;

public interface ITipoVehiculoService {

    public List<TipoVehiculo> listarTipoVehiculo();
    public void guardarTipoVehiculo(TipoVehiculo tipoVehiculo);
    public void eliminarTipoVehiculo(TipoVehiculo tipoVehiculo);
    public TipoVehiculo encontrarTipoVehiculo(TipoVehiculo tipoVehiculo);
}
