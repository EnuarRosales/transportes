package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.CambioAceite;
import com.CGDJ6.transportes.entities.ControlKilometraje;
import com.CGDJ6.transportes.repositories.CambioAceiteRepository;
import com.CGDJ6.transportes.repositories.ControlKilometrajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ControlKilometrajeService implements IControlKilometrajeService {

    @Autowired
    private ControlKilometrajeRepository controlKilometrajeRepository;

    @Autowired
    private CambioAceiteRepository cambioAceiteRepository;


    @Override
    public List<ControlKilometraje> listarControlKilometraje() {
        return (List<ControlKilometraje>) controlKilometrajeRepository.findAll();
    }

    @Override
    public void guardarControlKilometraje(ControlKilometraje controlKilometraje) {
        controlKilometrajeRepository.save(controlKilometraje);

    }

    @Override
    @Transactional
    public void eliminarControlKilometraje(ControlKilometraje controlKilometraje) {
        controlKilometrajeRepository.delete(controlKilometraje);

    }

    @Override
    public ControlKilometraje encontrarControlKilometraje(ControlKilometraje controlKilometraje) {
        return controlKilometrajeRepository.findById(controlKilometraje.getId()).orElse(null);
    }

    @Override
    public void eliminadoSuave(ControlKilometraje controlKilometraje) {

    }


}
