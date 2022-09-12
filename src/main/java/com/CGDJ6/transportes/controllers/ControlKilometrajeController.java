package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.ControlKilometraje;
import com.CGDJ6.transportes.services.ControlKilometrajeService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ControlKilometrajeController {

    ControlKilometrajeService controlKilometrajeService;


    public ControlKilometrajeController(ControlKilometrajeService controlKilometrajeService) {
        this.controlKilometrajeService = controlKilometrajeService;
    }


    @GetMapping("/ControlKilometraje")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var controlKilometrajes= controlKilometrajeService.listarControlKilometraje();
        model.addAttribute("controlKilometrajes", controlKilometrajes);
        return "layaut/controlKilometraje/ControlKilometraje";

    }

    @GetMapping("/agregarControlKilometraje")
    public String agregar(ControlKilometraje controlKilometraje) {
        return "modificarControlKilometraje";
    }

    @PostMapping("/guardarControlKilometraje")
    public String guardar(@Valid ControlKilometraje controlKilometraje, Errors errores) {
        if(errores.hasErrors()){
            return "modificarControlKilometraje";
        }
        controlKilometrajeService.guardarControlKilometraje(controlKilometraje);
        return "redirect:/ControlKilometraje";
    }


    @GetMapping("/editarControlKilometraje/{id}")
    public String editar(ControlKilometraje controlKilometraje, Model model) {
        controlKilometraje = controlKilometrajeService.encontrarControlKilometraje(controlKilometraje);
        model.addAttribute("controlKilometraje", controlKilometraje);
        return "layaut/controlKilometraje/modificarControlKilometraje";
    }


    @GetMapping("/eliminarControlKilometraje/{id}")
    public String eliminar(ControlKilometraje controlKilometraje) {
        controlKilometrajeService.eliminarControlKilometraje(controlKilometraje);
        return "redirect:/ControlKilometraje";
    }



}
