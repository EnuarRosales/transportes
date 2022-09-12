package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.AsignacionVehiculo;
import com.CGDJ6.transportes.services.AsignacionVehiculoService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AsignacionVehiculoController {

    AsignacionVehiculoService asignacionVehiculoService;

    public AsignacionVehiculoController(AsignacionVehiculoService asignacionVehiculoService) {
        this.asignacionVehiculoService = asignacionVehiculoService;
    }

    @GetMapping("/AsignacionVehiculo")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var asignacionVehiculos= asignacionVehiculoService.listarAsignacionVehiculo();
        model.addAttribute("asignacionVehiculos",asignacionVehiculos);
        return "layaut/asignacionVehiculo/AsignacionVehiculo";

    }

    @GetMapping("/agregarAsignacionVehiculo")
    public String agregar(AsignacionVehiculo asignacionVehiculo) {
        return "modificarAsignacionVehiculo";
    }

    @PostMapping("/guardarAsignacionVehiculo")
    public String guardar(@Valid AsignacionVehiculo asignacionVehiculo, Errors errores) {
        if(errores.hasErrors()){
            return "modificarAsignacionVehiculo";
        }
        asignacionVehiculoService.guardarAsignacionVehiculo(asignacionVehiculo);

        return "redirect:/AsignacionVehiculo";
    }


    @GetMapping("/editarAsignacionVehiculo/{id}")
    public String editar(AsignacionVehiculo asignacionVehiculo, Model model) {
        asignacionVehiculo = asignacionVehiculoService.encontrarAsignacionVehiculo(asignacionVehiculo);
        model.addAttribute("asignacionVehiculo", asignacionVehiculo);
        return "layaut/asignacionVehiculo/modificarAsignacionVehiculo";
    }


    @GetMapping("/eliminarAsignacionVehiculo/{id}")
    public String eliminar(AsignacionVehiculo asignacionVehiculo) {
        asignacionVehiculoService.eliminarAsignacionVehiculo(asignacionVehiculo);
        return "redirect:/AsignacionVehiculo";
    }



}
