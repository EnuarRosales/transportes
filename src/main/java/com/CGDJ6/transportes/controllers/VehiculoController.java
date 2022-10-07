package com.CGDJ6.transportes.controllers;


import com.CGDJ6.transportes.entities.CambioAceite;
import com.CGDJ6.transportes.entities.TipoUsuario;
import com.CGDJ6.transportes.entities.Usuario;
import com.CGDJ6.transportes.entities.Vehiculo;
import com.CGDJ6.transportes.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

@Controller
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    TipoVehiculoService tipoVehiculoService;

    @Autowired
    ServicioRealizadoService servicioRealizadoService;

    @Autowired
    CambioAceiteService cambioAceiteService;

    @Autowired
    UsuarioService usuarioService;



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

    /*@Autowired
    RedirectAttributes flash;*/

    @PostMapping("/guardarVehiculo")
    public String guardar(@Valid Vehiculo vehiculo, @RequestParam ("file") MultipartFile imagen, Errors errores, RedirectAttributes flash) {

        if(errores.hasErrors()){
            return "modificarVehiculo";
        }
        if(!imagen.isEmpty()){
           //Path directorioImagenes = Paths.get("src//main//resources//static/images");
            //String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            String rutaAbsoluta = "C://Users//User//OneDrive - Universidad Nacional Abierta y a Distancia//TRANSPORTES";
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta= Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);
                vehiculo.setImagen(imagen.getOriginalFilename());
                flash.addFlashAttribute("success","Vehiculo  Creado Correctamente");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        vehiculoService.guardarVehiculo(vehiculo);
        return "redirect:/Vehiculo";
    }

    //guarda cuando editamos un vehiculo
    @PostMapping("/guardarVehiculoEditado")
    public String guardar(@Valid Vehiculo vehiculo, Errors errores, RedirectAttributes flash) {
        if(errores.hasErrors()){
            return "modificarVehiculo";
        }
        vehiculoService.guardarVehiculo(vehiculo);
        flash.addFlashAttribute("success","Vehiculo  Editado Correctamente");
        return "redirect:/Vehiculo";
    }


    @GetMapping("/editarVehiculo/{placa}")
    public String editar(Vehiculo vehiculo, Model model) {
        vehiculo = vehiculoService.encontrarVehiculo(vehiculo);
        var tipoVehiculosl =tipoVehiculoService.listarTipoVehiculo();
        model.addAttribute("tipoVehiculosl", tipoVehiculosl);
        model.addAttribute("vehiculo", vehiculo);
        return "layaut/vehiculo/modificarVehiculo";
    }


/*
    @GetMapping("/detalleVehiculo/{placa}")
    public String detalleVehiculo(@PathVariable(value = "placa") String placa, Map<String,Object> model, RedirectAttributes flash) {

        Vehiculo vehiculo = vehiculoService.encontrarVehiculo(vehiculo);
        if(vehiculo)


        return "layaut/vehiculo/detalleVehiculo";
    }
    */

    @GetMapping("/detallesVehiculo/{placa}")
    public String detallesVehiculo(Vehiculo vehiculo, Model model) {
        vehiculo = vehiculoService.encontrarVehiculo(vehiculo);
        model.addAttribute("vehiculo", vehiculo);
        return "layaut/vehiculo/VehiculoDetalle";
    }



    @GetMapping("/eliminarVehiculo/{placa}")
    public String eliminar(Vehiculo vehiculo, RedirectAttributes flash) {
        vehiculoService.eliminarVehiculo(vehiculo);
        flash.addFlashAttribute("success","Vehiculo Eliminado Correctamente");
        return "redirect:/Vehiculo";
    }


    @GetMapping("/Vehiculo")
    public String inicioB(Model model, @Param ("palabraClave") String palabraClave) {
        var vehiculos= vehiculoService.listarVehiculo( palabraClave);
        var tipoVehiculosl =tipoVehiculoService.listarTipoVehiculo();
        model.addAttribute("tipoVehiculosl", tipoVehiculosl);
        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("palabraClave", palabraClave);
        model.addAttribute("totalVehiculos", vehiculos.size());
        System.out.println(vehiculos.size());

        return "layaut/vehiculo/Vehiculo";

    }

    @GetMapping("/eliminarVehiculoSuave/{placa}")
    public String eliminarS(Vehiculo vehiculo, RedirectAttributes flash) {
        vehiculoService.eliminadoSuave(vehiculo);
        flash.addFlashAttribute("success","Vehiculo Eliminado Correctamente");
        return "redirect:/Vehiculo";
    }


    @GetMapping("/")
    public String inicioBs(Model model, @Param ("palabraClave") String palabraClave) {

        int sumatoriaCambioAceite=0;
        for (CambioAceite listarCambioAceite : cambioAceiteService.listarCambioAceite()) {

            if (listarCambioAceite.getPendientePorConsumir() <= 1000 ) {
                sumatoriaCambioAceite = sumatoriaCambioAceite + 1;
            }
        }

        int sumatoriaVehiculos=0;
        int sumatoriaVehivulosExpiracionSeguro=0;
        int sumatoriaVehivulosExpiracionTecno=0;
        int sumatoriaUsuariosExpiracionLicencia=0;

        //OTRO CICLO
        for(Usuario listarUsuario : usuarioService.listarUsuario()){
            // La fecha actual
            Date fechaactual = new Date(System.currentTimeMillis());
            //cambiando fechas milisegundos para poder operar
            int milisecondsByDay = 86400000;
            int diasLicencia = (int) ((listarUsuario.getExpiracioLicenciaConduccion().getTime()-fechaactual.getTime()) / milisecondsByDay);

            //condicion para la alarma
            if(diasLicencia <=30){
                sumatoriaUsuariosExpiracionLicencia = sumatoriaUsuariosExpiracionLicencia+1;
                System.out.println(sumatoriaUsuariosExpiracionLicencia+"licencias");
            }


        }

        //OTRO CICLO
        for (Vehiculo listarVehiculo : vehiculoService.listarVehiculos()) {
            if (listarVehiculo.isActivo()==true ) {
                sumatoriaVehiculos = sumatoriaVehiculos + 1;
                // La fecha actual
                Date fechaactual = new Date(System.currentTimeMillis());
                //cambiando fechas milisegundos para poder operar
                int milisecondsByDay = 86400000;
                int diasSeguro = (int) ((listarVehiculo.getFechaExpiracionSeguro().getTime()-fechaactual.getTime()) / milisecondsByDay);
                int diasTecno = (int) ((listarVehiculo.getFechaExpiracionTecnomecanica().getTime()-fechaactual.getTime()) / milisecondsByDay);
                //condicion para la alarma
                if(diasSeguro <=30){
                    sumatoriaVehivulosExpiracionSeguro = sumatoriaVehivulosExpiracionSeguro+1;
                }
                if(diasTecno <=30){
                    sumatoriaVehivulosExpiracionTecno = sumatoriaVehivulosExpiracionTecno+1;
                    System.out.println(sumatoriaVehivulosExpiracionTecno+"mireeee");
                }
            }
        }

        var vehiculos= vehiculoService.listarVehiculo( palabraClave);
        var servicioRealizados= servicioRealizadoService.listarServicioRealizado();
        var tipoVehiculosl =tipoVehiculoService.listarTipoVehiculo();
        model.addAttribute("tipoVehiculosl", tipoVehiculosl);
        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("palabraClave", palabraClave);
        model.addAttribute("totalVehiculos", vehiculos.size());
        model.addAttribute("sumatoriaCambioAceite", sumatoriaCambioAceite);
        model.addAttribute("totalServicioRealizados", servicioRealizados.size());
        model.addAttribute("sumatoriaVehiculos", sumatoriaVehiculos);
        var cambioAceites= cambioAceiteService.listarCambioAceite();
        model.addAttribute("cambioAceites", cambioAceites);
        model.addAttribute("listadoCambioAceites", cambioAceites.size());
        model.addAttribute("sumatoriaVehivulosExpiracionSeguro", sumatoriaVehivulosExpiracionSeguro);
        model.addAttribute("sumatoriaVehivulosExpiracionTecno", sumatoriaVehivulosExpiracionTecno);
        model.addAttribute("sumatoriaUsuariosExpiracionLicencia", sumatoriaUsuariosExpiracionLicencia);


        return "index";

    }


    @GetMapping("/CambioAceiteDas")
    public String inicio(Model model, @AuthenticationPrincipal SecurityProperties.User user) {
        var cambioAceites= cambioAceiteService.listarCambioAceite();
        model.addAttribute("cambioAceites", cambioAceites);
        return "index";

    }


}
