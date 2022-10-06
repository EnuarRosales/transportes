package com.CGDJ6.transportes.controllers;

import com.CGDJ6.transportes.entities.CambioAceite;
import com.CGDJ6.transportes.entities.ControlKilometraje;
import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.entities.Vehiculo;
import com.CGDJ6.transportes.repositories.CambioAceiteRepository;
import com.CGDJ6.transportes.repositories.UsuarioRepository;
import com.CGDJ6.transportes.services.CambioAceiteService;
import com.CGDJ6.transportes.services.ControlKilometrajeService;
import com.CGDJ6.transportes.services.TipoUsuarioService;
import com.CGDJ6.transportes.services.VehiculoService;
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
public class ControlKilometrajeController {

    @Autowired
    ControlKilometrajeService controlKilometrajeService;

    @Autowired
    CambioAceiteService cambioAceiteService;

    @Autowired
    VehiculoService vehiculoService;

    @GetMapping("/ControlKilometraje")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var controlKilometrajes= controlKilometrajeService.listarControlKilometraje();
        model.addAttribute("controlKilometrajes", controlKilometrajes);
        model.addAttribute("TotalControlKilometrajes", controlKilometrajes.size());
        return "layaut/controlKilometraje/ControlKilometraje";

    }

    @GetMapping("/agregarControlKilometraje")
    public String agregar(ControlKilometraje controlKilometraje) {
        return "modificarControlKilometraje";
    }


    @PostMapping("/guardarControlKilometraje")
    public String guardar(@Valid ControlKilometraje controlKilometraje,RedirectAttributes flash) {

        Long variable = Long.valueOf(0);


        int variableIndex = 0;

        /*
                for(Vehiculo listarVehiculo : vehiculoService.listarVehiculos()){
                    if(listarVehiculo.getPlaca() == controlKilometraje.getVehiculo().getPlaca()){
                        variableIndex = i;
                        variable = cambioAceiteService.listarCambioAceite().get(i).getProximoCambioAceite();
                    }
                }
                */



        for (int i =0; i < cambioAceiteService.listarCambioAceite().size();i++){
            if(cambioAceiteService.listarCambioAceite().get(i).getVehiculo().getPlaca() == controlKilometraje.getVehiculo().getPlaca()){
               variableIndex = i;
               variable = cambioAceiteService.listarCambioAceite().get(i).getProximoCambioAceite();
            }


        }
        System.out.println(variableIndex+"indice");

        System.out.println(variable+"compare mijho");

        if(controlKilometraje.getVehiculo() != null){
            controlKilometraje.setKilometrajePorConsumir(variable-(controlKilometraje.getKilometrajePorConsumir()+controlKilometraje.getKilometraje()));
            for (int i =0; i < cambioAceiteService.listarCambioAceite().size();i++){
                if(cambioAceiteService.listarCambioAceite().get(variableIndex).isCambiado()==false){
                    cambioAceiteService.listarCambioAceite().get(variableIndex).setPendientePorConsumir(controlKilometraje.getKilometrajePorConsumir());
                    controlKilometrajeService.guardarControlKilometraje(controlKilometraje);
                    flash.addFlashAttribute("success","Kilometraje Registrado Correctamente");
                    return "redirect:/ControlKilometraje";
                }

            }
            /*
            cambioAceiteService.listarCambioAceite().get(variableIndex).setPendientePorConsumir(controlKilometraje.getKilometrajePorConsumir());
            System.out.println(controlKilometraje.getKilometrajePorConsumir() +" KILOMETRAJE POR CONSUMIR");
            controlKilometrajeService.guardarControlKilometraje(controlKilometraje);
            flash.addFlashAttribute("success","Kilometraje Registrado Correctamente");
            return "redirect:/ControlKilometraje";*/

        }


        flash.addFlashAttribute("error","Vehiculo  no existe  en la base de datos");
        return "redirect:/ControlKilometraje";
    }






    @GetMapping("/editarControlKilometraje/{id}")
    public String editar(ControlKilometraje controlKilometraje, Model model) {
        controlKilometraje = controlKilometrajeService.encontrarControlKilometraje(controlKilometraje);
        model.addAttribute("controlKilometraje", controlKilometraje);
        return "layaut/controlKilometraje/modificarControlKilometraje";
    }


    @GetMapping("/eliminarControlKilometraje/{id}")
    public String eliminar(ControlKilometraje controlKilometraje,RedirectAttributes flash) {
        controlKilometrajeService.eliminarControlKilometraje(controlKilometraje);
        flash.addFlashAttribute("success","Kilometraje Eliminado Correctamente");
        return "redirect:/ControlKilometraje";
    }



}
