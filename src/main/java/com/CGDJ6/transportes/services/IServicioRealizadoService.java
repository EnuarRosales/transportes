package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.ControlKilometraje;
import com.CGDJ6.transportes.entities.ServicioRealizado;

import java.util.List;

public interface IServicioRealizadoService {

    public List<ServicioRealizado> listarServicioRealizado();
    public void guardarServicioRealizado(ServicioRealizado  servicioRealizado);
    public void eliminarServicioRealizado(ServicioRealizado  servicioRealizado);
    public ServicioRealizado encontrarServicioRealizado (ServicioRealizado  servicioRealizado);
    public void eliminadoSuave(ServicioRealizado  servicioRealizado);
}
