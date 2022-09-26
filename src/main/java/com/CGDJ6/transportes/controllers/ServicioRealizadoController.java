package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.ServicioRealizado;
import com.CGDJ6.transportes.entities.Usuario;
import com.CGDJ6.transportes.services.ServicioRealizadoService;
import com.CGDJ6.transportes.services.TipoServicioService;
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
public class ServicioRealizadoController {

    @Autowired
    ServicioRealizadoService servicioRealizadoService;

    @Autowired
    TipoServicioService tipoServicioService;


    @GetMapping("/ServicioRealizado")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var servicioRealizados= servicioRealizadoService.listarServicioRealizado();
        var tipoServiciosl= tipoServicioService.listarTipoServicio();
        model.addAttribute("servicioRealizados", servicioRealizados);
        model.addAttribute("tipoServiciosl", tipoServiciosl);
        return "layaut/servicioRealizado/ServicioRealizado";

    }

    @GetMapping("/agregarServicioRealizado")
    public String agregar(ServicioRealizado servicioRealizado) {
        return "modificarServicioRealizado";
    }

    @PostMapping("/guardarServicioRealizado")
    public String guardar(@Valid ServicioRealizado servicioRealizado, Errors errores, RedirectAttributes flash) {
        if(errores.hasErrors()){
            return "modificarServicioRealizado";
        }
        servicioRealizadoService.guardarServicioRealizado(servicioRealizado);
        flash.addFlashAttribute("success","Mantenimiento Registrado Correctamente");
        return "redirect:/ServicioRealizado";
    }


    @GetMapping("/editarServicioRealizado/{id}")
    public String editar(ServicioRealizado servicioRealizado, Model model) {
        servicioRealizado = servicioRealizadoService.encontrarServicioRealizado(servicioRealizado);
        model.addAttribute("servicioRealizado", servicioRealizado);
        return "layaut/servicioRealizado/modificarServicioRealizado";
    }


    @GetMapping("/eliminarServicioRealizado/{id}")
    public String eliminar(ServicioRealizado servicioRealizado,RedirectAttributes flash) {
        servicioRealizadoService.eliminarServicioRealizado(servicioRealizado);
        flash.addFlashAttribute("success","Mantenimiento Eliminado Correctamente");
        return "redirect:/ServicioRealizado";
    }



}
