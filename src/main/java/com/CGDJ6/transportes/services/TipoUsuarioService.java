package com.CGDJ6.transportes.services;

import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.entities.TipoVehiculo;
import com.CGDJ6.transportes.repositories.TipoUsuarioRepository;
import com.CGDJ6.transportes.repositories.TipoVehiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoUsuarioService implements ITipoUsuarioService{

    private TipoUsuarioRepository tipoUsuarioRepository;


    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

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




}
