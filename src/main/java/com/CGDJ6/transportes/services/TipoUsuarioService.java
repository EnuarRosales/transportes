package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.repositories.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoUsuarioService implements ITipoUsuarioService{

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;


    @Override
    public List<TipoUsuario> listarTipoUsuario() {
        return (List<TipoUsuario>) tipoUsuarioRepository.findAll();
    }

    @Override
    public void guardarTipoUsuario(TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    @Transactional
    public void eliminarTipoUsuario(TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.delete(tipoUsuario);
    }

    @Override
    public TipoUsuario encontrarTipoUsuario(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.findById(tipoUsuario.getId()).orElse(null);
    }


    public  void eliminadoSuaveTipoUsuario(TipoUsuario tipoUsuario){
        tipoUsuarioRepository.findById(tipoUsuario.setActivo(false));
        tipoUsuarioRepository.

    }




}
