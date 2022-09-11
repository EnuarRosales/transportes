package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.AsignacionVehiculo;
import com.CGDJ6.transportes.entities.TipoServicio;
import com.CGDJ6.transportes.repositories.AsignacionVehiculoRepository;
import com.CGDJ6.transportes.repositories.TipoServicioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AsignacionVehiculoService implements IAsignacionVehiculoService {

    private AsignacionVehiculoRepository asignacionVehiculoRepository;

    public AsignacionVehiculoService(AsignacionVehiculoRepository asignacionVehiculoRepository) {
        this.asignacionVehiculoRepository = asignacionVehiculoRepository;
    }

    @Override
    public List<AsignacionVehiculo> listarAsignacionVehiculo() {
        return (List<AsignacionVehiculo>) asignacionVehiculoRepository.findAll();
    }

    @Override
    public void guardarAsignacionVehiculo(AsignacionVehiculo asignacionVehiculo) {
        asignacionVehiculoRepository.save(asignacionVehiculo);

    }

    @Override
    @Transactional
    public void eliminarAsignacionVehiculo(AsignacionVehiculo asignacionVehiculo) {
        asignacionVehiculoRepository.delete(asignacionVehiculo);

    }

    @Override
    public AsignacionVehiculo encontrarAsignacionVehiculo(AsignacionVehiculo asignacionVehiculo) {
        return asignacionVehiculoRepository.findById(asignacionVehiculo.getId()).orElse(null);
    }




}
