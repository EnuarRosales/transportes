package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.services.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tipo_Usuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public List<TipoUsuario> getUsuarios(){
        return tipoUsuarioService.getUsuarios();
    }

    @GetMapping (value = "/{id}")
    public Optional<TipoUsuario> getUsuarioById(@PathVariable Long id){
        return tipoUsuarioService.getUsuarioById(id);
    }

    @PostMapping
    public void create(@RequestBody TipoUsuario tipoUsuario){
        tipoUsuarioService.create(tipoUsuario);
    }


}
