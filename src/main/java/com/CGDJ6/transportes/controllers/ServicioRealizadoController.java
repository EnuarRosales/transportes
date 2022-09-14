package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.ServicioRealizado;
import com.CGDJ6.transportes.entities.Usuario;
import com.CGDJ6.transportes.services.ServicioRealizadoService;
import com.CGDJ6.transportes.services.UsuarioService;
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
public class ServicioRealizadoController {

    @Autowired
    ServicioRealizadoService servicioRealizadoService;


    @GetMapping("/ServicioRealizado")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var servicioRealizados= servicioRealizadoService.listarServicioRealizado();
        model.addAttribute("servicioRealizados", servicioRealizados);
        return "layaut/servicioRealizado/ServicioRealizado";

    }

    @GetMapping("/agregarServicioRealizado")
    public String agregar(ServicioRealizado servicioRealizado) {
        return "modificarServicioRealizado";
    }

    @PostMapping("/guardarServicioRealizado")
    public String guardar(@Valid ServicioRealizado servicioRealizado, Errors errores) {
        if(errores.hasErrors()){
            return "modificarServicioRealizado";
        }
        servicioRealizadoService.guardarServicioRealizado(servicioRealizado);
        return "redirect:/ServicioRealizado";
    }


    @GetMapping("/editarServicioRealizado/{id}")
    public String editar(ServicioRealizado servicioRealizado, Model model) {
        servicioRealizado = servicioRealizadoService.encontrarServicioRealizado(servicioRealizado);
        model.addAttribute("servicioRealizado", servicioRealizado);
        return "layaut/servicioRealizado/modificarServicioRealizado";
    }


    @GetMapping("/eliminarServicioRealizado/{id}")
    public String eliminar(ServicioRealizado servicioRealizado) {
        servicioRealizadoService.eliminarServicioRealizado(servicioRealizado);
        return "redirect:/ServicioRealizado";
    }



}
