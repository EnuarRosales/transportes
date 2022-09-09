package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.ControlKilometraje;

import java.util.List;

public interface IControlKilometrajeService {

    public List<ControlKilometraje> listarControlKilometraje ();
    public void guardarControlKilometraje(ControlKilometraje  controlKilometraje);
    public void eliminarControlKilometraje(ControlKilometraje  controlKilometraje);
    public ControlKilometraje encontrarControlKilometraje (ControlKilometraje  controlKilometraje);
}
