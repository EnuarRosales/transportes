package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.ServicioRealizado;
import com.CGDJ6.transportes.entities.TipoServicio;

import java.util.List;

public interface ITipoServicioService {

    public List<TipoServicio> listarTipoServicio();
    public void guardarTipoServicio(TipoServicio tipoServicio);
    public void eliminarTipoServicio(TipoServicio tipoServicio);
    public TipoServicio encontrarTipoServicio(TipoServicio tipoServicio);
}
