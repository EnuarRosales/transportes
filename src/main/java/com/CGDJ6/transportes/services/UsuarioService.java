package com.CGDJ6.transportes.services;


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




}
