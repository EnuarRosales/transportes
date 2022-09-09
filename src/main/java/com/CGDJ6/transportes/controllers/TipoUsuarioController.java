package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.services.TipoUsuarioService;
import com.CGDJ6.transportes.services.UsuarioService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TipoUsuarioController {

    TipoUsuarioService tipoUsuarioService;


    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping("/TipoUsuario")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var tipoUsuarios= tipoUsuarioService.listarTipoUsuario();
        model.addAttribute("tipoUsuarios", tipoUsuarios);
        return "TipoUsuario";

    }

    @GetMapping("/agregarTipoUsuario")
    public String agregar(TipoUsuario tipoUsuario) {
        return "modificarTipoUsuario";
    }

    @PostMapping("/guardarTipoUsuario")
    public String guardar(@Valid TipoUsuario tipoUsuario, Errors errores) {
        if(errores.hasErrors()){
            return "modificarTipoUsuario";
        }
        tipoUsuarioService.guardarTipoUsuario(tipoUsuario);
        return "redirect:/TipoUsuario";
    }




    @GetMapping("/editarTipoUsuario/{id}")
    public String editar(TipoUsuario tipoUsuario, Model model) {
        tipoUsuario = tipoUsuarioService.encontrarTipoUsuario(tipoUsuario);
        model.addAttribute("tipoUsuario", tipoUsuario);
        return "modificarTipoUsuario";
    }


    @GetMapping("/eliminarTipoUsuario/{id}")
    public String eliminar(TipoUsuario tipoUsuario) {
        tipoUsuarioService.eliminarTipoUsuario(tipoUsuario);
        return "redirect:/TipoUsuario";
    }



}
