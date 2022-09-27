package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.entities.TipoVehiculo;
import com.CGDJ6.transportes.entities.Usuario;
import com.CGDJ6.transportes.services.TipoServicioService;
import com.CGDJ6.transportes.services.TipoUsuarioService;
import com.CGDJ6.transportes.services.TipoVehiculoService;
import com.CGDJ6.transportes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TipoUsuarioService tipoUsuarioService;


    @GetMapping("/Usuario")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var usuarios= usuarioService.listarUsuario();
       var usuariosl =tipoUsuarioService.listarTipoUsuario();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuariosl", usuariosl);
        return "layaut/usuario/Usuario";

    }

    @GetMapping("/agregarUsuario")
    public String agregar(Usuario usuario) {
        return "modificarUsuario";
    }

    //sirve para crear Y GURDAR A LA VEZ LOS  usuarios
    @PostMapping("/guardarUsuario")
    public String guardar(@Valid Usuario usuario, Errors errores, RedirectAttributes flash) {
        if(errores.hasErrors()){
            return "modificarUsuario";
        }
        usuarioService.guardarUsuario(usuario);
        flash.addFlashAttribute("success","Usuario  Creado Correctamente");
        return "redirect:/Usuario";
    }


//SIRVE PARA ENCONTRAR EL DATO A EDITAR
    @GetMapping("/editarUsuario/{cedula}")
    public String editar(Usuario usuario, Model model) {
        usuario = usuarioService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "layaut/usuario/modificarUsuario";
    }


    @GetMapping("/eliminarUsuario/{cedula}")
    public String eliminar(Usuario usuario,RedirectAttributes flash) {
        usuarioService.eliminarUsuario(usuario);
        flash.addFlashAttribute("success","Usuario  Eliminado Correctamente");
        return "redirect:/Usuario";
    }

    @GetMapping("/eliminarUsuarioSuave/{cedula}")
    public String eliminarS(Usuario usuario,RedirectAttributes flash) {
        usuarioService.eliminadoSuave(usuario);
        flash.addFlashAttribute("success","Usuario  Eliminado Correctamente");
        return "redirect:/Usuario";
    }



}
