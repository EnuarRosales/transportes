package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.ServicioRealizado;
import com.CGDJ6.transportes.entities.TipoServicio;
import com.CGDJ6.transportes.repositories.ServicioRealizadoRepository;
import com.CGDJ6.transportes.repositories.TipoServicioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoServicioService implements ITipoServicioService {

    private TipoServicioRepository tipoServicioRepository;


    public TipoServicioService(TipoServicioRepository tipoServicioRepository) {
        this.tipoServicioRepository = tipoServicioRepository;
    }

    @Override
    public List<TipoServicio> listarTipoServicio() {
        return (List<TipoServicio>) tipoServicioRepository.findAll();
    }

    @Override
    public void guardarTipoServicio(TipoServicio tipoServicio) {
        tipoServicioRepository.save(tipoServicio);

    }

    @Override
    @Transactional
    public void eliminarTipoServicio(TipoServicio tipoServicio) {
        tipoServicioRepository.delete(tipoServicio);

    }

    @Override
    public TipoServicio encontrarTipoServicio(TipoServicio tipoServicio) {
        return tipoServicioRepository.findById(tipoServicio.getId()).orElse(null);
    }





}
