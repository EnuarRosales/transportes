package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.repositories.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepo;

    public void create(TipoUsuario tipoUsuario){
        tipoUsuarioRepo.save(tipoUsuario);
    }

    public List<TipoUsuario> getUsuarios(){
        return tipoUsuarioRepo.findAll();
    }

    public Optional<TipoUsuario> getUsuarioById(Long id){
        return tipoUsuarioRepo.findById(id);
    }


}
