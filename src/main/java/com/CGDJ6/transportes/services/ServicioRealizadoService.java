package com.CGDJ6.transportes.services;


import com.CGDJ6.transportes.entities.ServicioRealizado;
import com.CGDJ6.transportes.repositories.ServicioRealizadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioRealizadoService implements IServicioRealizadoService {

    @Autowired
    private ServicioRealizadoRepository servicioRealizadoRepository;



    @Override
    public List<ServicioRealizado> listarServicioRealizado() {
        return (List<ServicioRealizado>) servicioRealizadoRepository.findAll();
    }

    @Override
    public void guardarServicioRealizado(ServicioRealizado servicioRealizado) {
        servicioRealizadoRepository.save(servicioRealizado);

    }

    @Override
    @Transactional
    public void eliminarServicioRealizado(ServicioRealizado servicioRealizado) {
        servicioRealizadoRepository.delete(servicioRealizado);

    }

    @Override
    public ServicioRealizado encontrarServicioRealizado(ServicioRealizado servicioRealizado) {
        return servicioRealizadoRepository.findById(servicioRealizado.getId()).orElse(null);
    }

    @Override
    public void eliminadoSuave(ServicioRealizado servicioRealizado) {

    }


}
