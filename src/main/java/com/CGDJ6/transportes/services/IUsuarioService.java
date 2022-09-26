package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.TipoVehiculo;
import com.CGDJ6.transportes.entities.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> listarUsuario();
    public void guardarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    public Usuario encontrarUsuario(Usuario usuario);

    public void eliminadoSuave(Usuario usuario);
}
