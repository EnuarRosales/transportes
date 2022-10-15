package com.CGDJ6.transportes.services;


import com.CGDJ6.transportes.entities.Vehiculo;
import com.CGDJ6.transportes.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;


    @Override
    public List<Vehiculo> listarVehiculo(String palabraClave) {
        if (palabraClave != null) {
            return vehiculoRepository.findAll(palabraClave);
        }
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    @Override
    public List<Vehiculo> listarVehiculos() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    @Override
    public void guardarVehiculo(Vehiculo vehiculo) {
        vehiculo.setImagen(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getImagen());
        vehiculoRepository.save(vehiculo);

    }

    @Override
    @Transactional
    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.delete(vehiculo);

    }

    @Override
    public Vehiculo encontrarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null);
    }

    @Override
    public void eliminadoSuave(Vehiculo vehiculo) {
        vehiculo.setActivo(false);
        vehiculo.setTipoVehiculo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getTipoVehiculo());
        vehiculo.setModelo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getModelo());
        vehiculo.setMarca(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getMarca());
        vehiculo.setColor(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getColor());
        vehiculo.setAnoVehiculo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getAnoVehiculo());
        vehiculo.setFechaExpiracionSeguro(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getFechaExpiracionSeguro());
        vehiculo.setFechaExpiracionTecnomecanica(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getFechaExpiracionTecnomecanica());
        vehiculo.setImagen(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getImagen());
        vehiculoRepository.save(vehiculo);
    }

    @Override

    public void cambioEstadoSeguroF(Vehiculo vehiculo) {
        vehiculo.setSeguroVigente(false);
        vehiculo.setTipoVehiculo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getTipoVehiculo());
        vehiculo.setModelo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getModelo());
        vehiculo.setMarca(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getMarca());
        vehiculo.setColor(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getColor());
        vehiculo.setAnoVehiculo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getAnoVehiculo());
        vehiculo.setFechaExpiracionSeguro(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getFechaExpiracionSeguro());
        vehiculo.setFechaExpiracionTecnomecanica(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getFechaExpiracionTecnomecanica());
        vehiculo.setImagen(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getImagen());
        vehiculo.setServicioRealizado(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getServicioRealizado());
        vehiculo.setControlKilometraje(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getControlKilometraje());
        vehiculo.setAsignacionVehiculo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getAsignacionVehiculo());
        vehiculo.setCambioAceite(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getCambioAceite());
        vehiculo.setActivo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).isActivo());
        vehiculo.setTecnomecanicaVigente(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).isTecnomecanicaVigente());
        vehiculoRepository.save(vehiculo);
    }

    @Override
    public void cambioEstadoSeguroT(Vehiculo vehiculo) {
        vehiculo.setSeguroVigente(true);
        vehiculo.setTipoVehiculo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getTipoVehiculo());
        vehiculo.setModelo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getModelo());
        vehiculo.setMarca(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getMarca());
        vehiculo.setColor(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getColor());
        vehiculo.setAnoVehiculo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getAnoVehiculo());
        vehiculo.setFechaExpiracionSeguro(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getFechaExpiracionSeguro());
        vehiculo.setFechaExpiracionTecnomecanica(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getFechaExpiracionTecnomecanica());
        vehiculo.setImagen(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getImagen());
        vehiculo.setServicioRealizado(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getServicioRealizado());
        vehiculo.setControlKilometraje(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getControlKilometraje());
        vehiculo.setAsignacionVehiculo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getAsignacionVehiculo());
        vehiculo.setCambioAceite(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).getCambioAceite());
        vehiculo.setActivo(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).isActivo());
        vehiculo.setTecnomecanicaVigente(vehiculoRepository.findById(vehiculo.getPlaca()).orElse(null).isTecnomecanicaVigente());
        vehiculoRepository.save(vehiculo);
    }




}
