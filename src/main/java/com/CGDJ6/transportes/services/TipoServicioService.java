package com.CGDJ6.transportes.services;


import com.CGDJ6.transportes.entities.TipoServicio;
import com.CGDJ6.transportes.repositories.TipoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoServicioService implements ITipoServicioService {

    @Autowired
    private TipoServicioRepository tipoServicioRepository;



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

    @Override
    public void eliminadoSuave(TipoServicio tipoServicio) {

    }


}
