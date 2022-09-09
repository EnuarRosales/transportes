package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontTipoUsuarioController {

    @Autowired
    TipoUsuarioService tipoUsuarioService;


    @GetMapping("/")
    public String tipoUsuario(Model model){
    List<TipoUsuario> tipoUsuarios = tipoUsuarioService.getUsuarios();
    model.addAttribute("tipoUsuarios",tipoUsuarios);
        return "tipoUsuario";
    }
}
