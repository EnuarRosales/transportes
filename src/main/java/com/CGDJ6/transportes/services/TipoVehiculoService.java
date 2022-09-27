package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.entities.TipoVehiculo;
import com.CGDJ6.transportes.repositories.TipoVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoVehiculoService implements ITipoVehiculoService{


    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;


    @Override
    public List<TipoVehiculo> listarTipoVehiculo() {
        return (List<TipoVehiculo>) tipoVehiculoRepository.findAll();
    }

    @Override
    public void guardarTipoVehiculo(TipoVehiculo tipoVehiculo) {
        tipoVehiculoRepository.save(tipoVehiculo);

    }

    @Override
    @Transactional
    public void eliminarTipoVehiculo(TipoVehiculo tipoVehiculo) {
        tipoVehiculoRepository.delete(tipoVehiculo);

    }

    @Override
    public TipoVehiculo encontrarTipoVehiculo(TipoVehiculo tipoVehiculo) {
        return tipoVehiculoRepository.findById(tipoVehiculo.getId()).orElse(null);
    }

    @Override
    public void eliminadoSuave(TipoVehiculo tipoVehiculo) {
        tipoVehiculo.setActivo(false);
        tipoVehiculo.setDescripcion(tipoVehiculoRepository.findById(tipoVehiculo.getId()).orElse(null).getDescripcion());
        tipoVehiculoRepository.save(tipoVehiculo);
    }





}
