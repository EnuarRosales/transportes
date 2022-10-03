package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.AsignacionVehiculo;
import com.CGDJ6.transportes.entities.CambioAceite;

import java.util.List;

public interface ICambioAceite {

    public List<CambioAceite> listarCambioAceite ();
    public void guardarCambioAceite(CambioAceite  cambioAceite);
    public void eliminarCambioAceite(CambioAceite  cambioAceite);
    public CambioAceite encontrarCambioAceite(CambioAceite cambioAceite);
    public void eliminadoSuave(CambioAceite  cambioAceite);

    public void cambioAceiteRealizado(CambioAceite  cambioAceite);



}
