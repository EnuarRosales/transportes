package com.CGDJ6.transportes.controllers;


import com.CGDJ6.transportes.entities.Vehiculo;
import com.CGDJ6.transportes.services.VehiculoService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class VehiculoController {

    VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }
/*
    @GetMapping("/Vehiculo")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var vehiculos= vehiculoService.listarVehiculo();
        model.addAttribute("vehiculos", vehiculos);
        return "layaut/vehiculo/Vehiculo";

    }*/

    @GetMapping("/agregarVehiculo")
    public String agregar(Vehiculo vehiculo) {
        return "modificarVehiculo";
    }

    @PostMapping("/guardarVehiculo")
    public String guardar(@Valid Vehiculo vehiculo, Errors errores) {
        if(errores.hasErrors()){
            return "modificarVehiculo";
        }
        vehiculoService.guardarVehiculo(vehiculo);
        return "redirect:/Vehiculo";
    }


    @GetMapping("/editarVehiculo/{placa}")
    public String editar(Vehiculo vehiculo, Model model) {
        vehiculo = vehiculoService.encontrarVehiculo(vehiculo);
        model.addAttribute("vehiculo", vehiculo);
        return "layaut/vehiculo/modificarVehiculo";
    }


    @GetMapping("/eliminarVehiculo/{placa}")
    public String eliminar(Vehiculo vehiculo) {
        vehiculoService.eliminarVehiculo(vehiculo);
        return "redirect:/Vehiculo";
    }


    @GetMapping("/Vehiculo")
    public String inicioB(Model model, @Param ("palabraClave") String palabraClave) {
        var vehiculos= vehiculoService.listarVehiculo( palabraClave);
        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("palabraClave", palabraClave);
        return "layaut/vehiculo/Vehiculo";

    }






}
