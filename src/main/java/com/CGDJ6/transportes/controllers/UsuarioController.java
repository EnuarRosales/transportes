package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.TipoVehiculo;
import com.CGDJ6.transportes.entities.Usuario;
import com.CGDJ6.transportes.services.TipoVehiculoService;
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
public class UsuarioController {

    UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/Usuario")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var usuarios= usuarioService.listarUsuario();
        model.addAttribute("usuarios", usuarios);
        return "layaut/usuario/Usuario";

    }

    @GetMapping("/agregarUsuario")
    public String agregar(Usuario usuario) {
        return "modificarUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardar(@Valid Usuario usuario, Errors errores) {
        if(errores.hasErrors()){
            return "modificarUsuario";
        }
        usuarioService.guardarUsuario(usuario);
        return "redirect:/Usuario";
    }


    @GetMapping("/editarUsuario/{cedula}")
    public String editar(Usuario usuario, Model model) {
        usuario = usuarioService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "layaut/usuario/modificarUsuario";
    }


    @GetMapping("/eliminarUsuario/{cedula}")
    public String eliminar(Usuario usuario) {
        usuarioService.eliminarUsuario(usuario);
        return "redirect:/Usuario";
    }



}
