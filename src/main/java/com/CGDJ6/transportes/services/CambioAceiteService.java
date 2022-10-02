package com.CGDJ6.transportes.services;


import com.CGDJ6.transportes.entities.CambioAceite;
import com.CGDJ6.transportes.entities.ServicioRealizado;
import com.CGDJ6.transportes.entities.Usuario;
import com.CGDJ6.transportes.repositories.CambioAceiteRepository;
import com.CGDJ6.transportes.repositories.ServicioRealizadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CambioAceiteService implements ICambioAceite {

    @Autowired
    private CambioAceiteRepository cambioAceiteRepository;



    @Override
    public List<CambioAceite> listarCambioAceite() {
        return (List<CambioAceite>) cambioAceiteRepository.findAll();
    }

    @Override
    public void guardarCambioAceite(CambioAceite cambioAceite) {
        cambioAceiteRepository.save(cambioAceite);
    }

    @Override
    public void eliminarCambioAceite(CambioAceite cambioAceite) {
        cambioAceiteRepository.delete(cambioAceite);
    }

    @Override
    public CambioAceite encontrarCambioAceite(CambioAceite cambioAceite) {
        return cambioAceiteRepository.findById(cambioAceite.getId()).orElse(null);
    }

    @Override
    public void eliminadoSuave(CambioAceite cambioAceite) {
        cambioAceite.setActivo(false);
        cambioAceite.setVehiculo(cambioAceiteRepository.findById(cambioAceite.getId()).orElse(null).getVehiculo());
        cambioAceite.setFechaCambioAceite(cambioAceiteRepository.findById(cambioAceite.getId()).orElse(null).getFechaCambioAceite());
        cambioAceite.setKilometrajeCambioAceite(cambioAceiteRepository.findById(cambioAceite.getId()).orElse(null).getKilometrajeCambioAceite());
        cambioAceiteRepository.save(cambioAceite);
    }


}
