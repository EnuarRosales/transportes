package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.TipoServicio;
import com.CGDJ6.transportes.entities.TipoUsuario;

import java.util.List;

public interface ITipoUsuarioService {

    public List<TipoUsuario> listarTipoUsuario();
    public void guardarTipoUsuario(TipoUsuario tipoUsuario);
    public void eliminarTipoUsuario(TipoUsuario tipoUsuario);
    public TipoUsuario encontrarTipoUsuario(TipoUsuario tipoUsuario);
    public void eliminadoSuave(TipoUsuario tipoUsuario);




}
