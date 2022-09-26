package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.TipoVehiculo;
import com.CGDJ6.transportes.services.TipoVehiculoService;
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
public class TipoVehiculoController {

    @Autowired
    TipoVehiculoService tipoVehiculoService;


    @GetMapping("/TipoVehiculo")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var tipoVehiculos= tipoVehiculoService.listarTipoVehiculo();
        model.addAttribute("tipoVehiculos", tipoVehiculos);
        return "layaut/tipoVehiculo/TipoVehiculo";

    }

    @GetMapping("/agregarTipoVehiculo")
    public String agregar(TipoVehiculo tipoVehiculo) {
        return "modificarTipoVehiculo";
    }

    @PostMapping("/guardarTipoVehiculo")
    public String guardar(@Valid TipoVehiculo tipoVehiculo, Errors errores, RedirectAttributes flash) {
        if(errores.hasErrors()){
            return "modificarTipoVehiculo";
        }
        tipoVehiculoService.guardarTipoVehiculo(tipoVehiculo);
        flash.addFlashAttribute("success","Tipo Vehiculo  Creado Correctamente");
        return "redirect:/TipoVehiculo";
    }


    @GetMapping("/editarTipoVehiculo/{id}")
    public String editar(TipoVehiculo tipoVehiculo, Model model) {
        tipoVehiculo = tipoVehiculoService.encontrarTipoVehiculo(tipoVehiculo);
        model.addAttribute("tipoVehiculo", tipoVehiculo);
        return "layaut/tipoVehiculo/modificarTipoVehiculo";
    }


    @GetMapping("/eliminarTipoVehiculo/{id}")
    public String eliminar(TipoVehiculo tipoVehiculo,RedirectAttributes flash) {
        tipoVehiculoService.eliminarTipoVehiculo(tipoVehiculo);
        flash.addFlashAttribute("success","Tipo Vehiculo  Eliminado Correctamente");
        return "redirect:/TipoVehiculo";
    }



}
