package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.AsignacionVehiculo;
import com.CGDJ6.transportes.services.AsignacionVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AsignacionVehiculoController {

    @Autowired
    AsignacionVehiculoService asignacionVehiculoService;

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
    public String guardar(@Valid AsignacionVehiculo asignacionVehiculo, Errors errores, BindingResult bindingResult, RedirectAttributes flash) {

        if (bindingResult.hasErrors()) {
            // Aquí se puede hacer cualquier cosa, yo hago una redirección para mostrar los errores en el form
            System.out.println("entro el error");
            return "redirect:/AsignacionVehiculo";
        }


        if(errores.hasErrors()){
            return "redirect:/AsignacionVehiculo";
        }
        try {
            asignacionVehiculoService.guardarAsignacionVehiculo(asignacionVehiculo);
            flash.addFlashAttribute("success","Vehiculo  Asignado Correctamente");
        } catch (Exception e) {
            return "redirect:/modificarAsignacionVehiculo";

        }

        return "redirect:/AsignacionVehiculo";
    }


    @GetMapping("/editarAsignacionVehiculo/{id}")
    public String editar(AsignacionVehiculo asignacionVehiculo, Model model) {
        asignacionVehiculo = asignacionVehiculoService.encontrarAsignacionVehiculo(asignacionVehiculo);
        model.addAttribute("asignacionVehiculo", asignacionVehiculo);
        return "layaut/asignacionVehiculo/modificarAsignacionVehiculo";
    }


    @GetMapping("/eliminarAsignacionVehiculo/{id}")
    public String eliminar(AsignacionVehiculo asignacionVehiculo,RedirectAttributes flash) {
        asignacionVehiculoService.eliminarAsignacionVehiculo(asignacionVehiculo);
        flash.addFlashAttribute("success","Vehiculo  Eliminado Correctamente");
        return "redirect:/AsignacionVehiculo";
    }

    @GetMapping("/eliminarAsignacionVehiculoSuave/{id}")
    public String eliminarS(AsignacionVehiculo asignacionVehiculo,RedirectAttributes flash) {
        asignacionVehiculoService.eliminadoSuave(asignacionVehiculo);
        flash.addFlashAttribute("success","Vehiculo  Eliminado Correctamente");
        return "redirect:/AsignacionVehiculo";
    }



}
