package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.ControlKilometraje;
import com.CGDJ6.transportes.repositories.ControlKilometrajeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ControlKilometrajeService implements IControlKilometrajeService {

    private ControlKilometrajeRepository controlKilometrajeRepository;


    public ControlKilometrajeService(ControlKilometrajeRepository controlKilometrajeRepository) {
        this.controlKilometrajeRepository = controlKilometrajeRepository;
    }

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



}
