package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.services.TipoUsuarioService;
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

@Controller
public class TipoUsuarioController {

    @Autowired
    TipoUsuarioService tipoUsuarioService;


    @GetMapping("/TipoUsuario")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var tipoUsuarios= tipoUsuarioService.listarTipoUsuario();
        model.addAttribute("tipoUsuarios", tipoUsuarios);
        return "layaut/tipoUsuario/TipoUsuario";

    }

    @GetMapping("/agregarTipoUsuario")
    public String agregar(TipoUsuario tipoUsuario) {
        return "modificarTipoUsuario";
    }

    @PostMapping("/guardarTipoUsuario")
    public String guardar(@Valid TipoUsuario tipoUsuario, Errors errores, RedirectAttributes flash) {
        if(errores.hasErrors()){
            return "modificarTipoUsuario";
        }
        tipoUsuarioService.guardarTipoUsuario(tipoUsuario);
        flash.addFlashAttribute("success","Tipo Usuario  Creado Correctamente");
        return "redirect:/TipoUsuario";
    }



    @GetMapping("/editarTipoUsuario/{id}")
    public String editar(TipoUsuario tipoUsuario, Model model) {
        tipoUsuario = tipoUsuarioService.encontrarTipoUsuario(tipoUsuario);
        model.addAttribute("tipoUsuario", tipoUsuario);
        return "layaut/tipoUsuario/modificarTipoUsuario";
    }


    @GetMapping("/eliminarTipoUsuario/{id}")
    public String eliminar(TipoUsuario tipoUsuario,RedirectAttributes flash) {
        tipoUsuarioService.eliminarTipoUsuario(tipoUsuario);
        flash.addFlashAttribute("success","Tipo Usuario  Eliminado Correctamente");
        return "redirect:/TipoUsuario";
    }

    @GetMapping("/eliminarTipoUsuarioSuave/{id}")
    public String eliminarS(TipoUsuario tipoUsuario,RedirectAttributes flash) {
        tipoUsuarioService.eliminadoSuave(tipoUsuario);
        flash.addFlashAttribute("success","Tipo Usuario  Eliminado Correctamente");
        return "redirect:/TipoUsuario";
    }




}
