package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.CambioAceite;
import com.CGDJ6.transportes.services.CambioAceiteService;
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
public class CambioAceiteController {

    @Autowired
    CambioAceiteService cambioAceiteService;



    @GetMapping("/CambioAceite")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var cambioAceites= cambioAceiteService.listarCambioAceite();
        model.addAttribute("cambioAceites", cambioAceites);
        return "layaut/cambioAceite/CambioAceite";

    }

    @GetMapping("/agregarCambioAceite")
    public String agregar(CambioAceite cambioAceite) {
        return "modificarCambioAceite";
    }


    @PostMapping("/guardarCambioAceite")
    public String guardar(@Valid CambioAceite cambioAceite, RedirectAttributes flash) {

        if(cambioAceite.getVehiculo() != null){
            cambioAceiteService.guardarCambioAceite(cambioAceite);
            flash.addFlashAttribute("success","Cambio de aceite Creado Correctamente");
            return "redirect:/CambioAceite";

        }

        flash.addFlashAttribute("error","El Vehiculo no Existe en la Base de Datos");
        return "redirect:/CambioAceite";
    }


    @GetMapping("/editarCambioAceite/{id}")
    public String editar(CambioAceite cambioAceite, Model model) {
        cambioAceite = cambioAceiteService.encontrarCambioAceite(cambioAceite);
        model.addAttribute("cambioAceite", cambioAceite);
        return "layaut/cambioAceite/modificarCambioAceite";
    }


    @GetMapping("/eliminarCambioAceite/{id}")
    public String eliminar(CambioAceite cambioAceite,RedirectAttributes flash) {
        cambioAceiteService.eliminarCambioAceite(cambioAceite);
        flash.addFlashAttribute("success","Cambio de Aceite   Eliminado Correctamente");
        return "redirect:/CambioAceite";
    }

    @GetMapping("/eliminarCambioAceiteSuave/{id}")
    public String eliminarS(CambioAceite cambioAceite,RedirectAttributes flash) {
        cambioAceiteService.eliminadoSuave(cambioAceite);
        flash.addFlashAttribute("success","Cambio de Aceite Eliminado Correctamente");
        return "redirect:/CambioAceite";
    }

    @GetMapping("/cambioEstadoCambioAceite/{id}")
    public String cambio(CambioAceite cambioAceite,RedirectAttributes flash) {
        cambioAceiteService.cambioAceiteRealizado(cambioAceite);
        flash.addFlashAttribute("success","Cambio de Aceite Realizado Correctamente");
        return "redirect:/CambioAceite";
    }



}
