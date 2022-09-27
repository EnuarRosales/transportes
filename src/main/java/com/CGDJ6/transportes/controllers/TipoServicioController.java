package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.TipoServicio;
import com.CGDJ6.transportes.entities.TipoVehiculo;
import com.CGDJ6.transportes.services.TipoServicioService;
import com.CGDJ6.transportes.services.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TipoServicioController {

    @Autowired
    TipoServicioService tipoServicioService;





    @GetMapping("/TipoServicio")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var tipoServicios= tipoServicioService.listarTipoServicio();

        model.addAttribute("tipoServicios", tipoServicios);
        return "layaut/tipoServicio/TipoServicio";

    }

    @GetMapping("/agregarTipoServicio")
    public String agregar(TipoServicio tipoServicio) {
        return "modificarTipoServicio";
    }

    @PostMapping("/guardarTipoServicio")
    public String guardar(@Valid TipoServicio tipoServicio, Errors errores) {
        if(errores.hasErrors()){
            return "modificarTipoServicio";
        }
        tipoServicioService.guardarTipoServicio(tipoServicio);
        return "redirect:/TipoServicio";
    }


    @GetMapping("/editarTipoServicio/{id}")
    public String editar(TipoServicio tipoServicio, Model model) {
        tipoServicio = tipoServicioService.encontrarTipoServicio(tipoServicio);
        model.addAttribute("tipoServicio", tipoServicio);
        return "layaut/tipoServicio/modificarTipoServicio";
    }


    @GetMapping("/eliminarTipoServicio/{id}")
    public String eliminar(TipoServicio tipoServicio) {
        tipoServicioService.eliminarTipoServicio(tipoServicio);
        return "redirect:/TipoServicio";
    }



}
