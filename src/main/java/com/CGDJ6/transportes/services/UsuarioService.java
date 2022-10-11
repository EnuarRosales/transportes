package com.CGDJ6.transportes.services;


import com.CGDJ6.transportes.entities.TipoVehiculo;
import com.CGDJ6.transportes.entities.Usuario;
import com.CGDJ6.transportes.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuario() {
        return (List<Usuario>)usuarioRepository.findAll() ;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);

    }

    @Override
    @Transactional
    public void eliminarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);

    }

    @Override
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuarioRepository.findById(usuario.getCedula()).orElse(null);
    }

    @Override
    public void eliminadoSuave(Usuario usuario) {
        usuario.setActivo(false);
        usuario.setUsuario(usuarioRepository.findById(usuario.getCedula()).orElse(null).getUsuario());
        usuario.setGrado(usuarioRepository.findById(usuario.getCedula()).orElse(null).getGrado());
        usuario.setNombre(usuarioRepository.findById(usuario.getCedula()).orElse(null).getNombre());
        usuario.setExpiracioLicenciaConduccion(usuarioRepository.findById(usuario.getCedula()).orElse(null).getExpiracioLicenciaConduccion());
        usuario.setActivo(usuarioRepository.findById(usuario.getCedula()).orElse(null).isActivo());
        usuarioRepository.save(usuario);
    }

    @Override
    public void cambioEstadoLicencia(Usuario usuario) {
        usuario.setLicenciaConduccionVigente(false);
        usuario.setUsuario(usuarioRepository.findById(usuario.getCedula()).orElse(null).getUsuario());
        usuario.setGrado(usuarioRepository.findById(usuario.getCedula()).orElse(null).getGrado());
        usuario.setNombre(usuarioRepository.findById(usuario.getCedula()).orElse(null).getNombre());
        usuario.setExpiracioLicenciaConduccion(usuarioRepository.findById(usuario.getCedula()).orElse(null).getExpiracioLicenciaConduccion());
        usuario.setActivo(usuarioRepository.findById(usuario.getCedula()).orElse(null).isActivo());
        usuarioRepository.save(usuario);

    }




}
