package com.CGDJ6.transportes.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//@Data
@Entity
public class Vehiculo /*implements Serializable */{
    //private  static final  long serialVersionUID =1L;
    @Id
    private String placa;
    @ManyToOne
    @JoinColumn(name = "tipo_vehiculo_id")
    private  TipoVehiculo tipoVehiculo;

    private  Integer modelo;

    private  String marca;

    private  String imagen;

    @JsonIgnore
    @OneToMany(mappedBy = "vehiculo")
    private List<ServicioRealizado> servicioRealizado;

    @JsonIgnore
    @OneToMany(mappedBy = "vehiculo")
    private  List<ControlKilometraje>controlKilometraje;

    @JsonIgnore
    @OneToMany(mappedBy = "vehiculo")
    private  List<AsignacionVehiculo> asignacionVehiculo;

    @JsonIgnore
    @OneToMany(mappedBy = "vehiculo")
    private List<CambioAceite> cambioAceite;



    private boolean activo =true;


    public Vehiculo() {
    }

    public Vehiculo(String placa, TipoVehiculo tipoVehiculo, Integer modelo, String marca, String imagen, List<ServicioRealizado> servicioRealizado, List<ControlKilometraje> controlKilometraje, List<AsignacionVehiculo> asignacionVehiculo, List<CambioAceite> cambioAceite, boolean activo) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.modelo = modelo;
        this.marca = marca;
        this.imagen = imagen;
        this.servicioRealizado = servicioRealizado;
        this.controlKilometraje = controlKilometraje;
        this.asignacionVehiculo = asignacionVehiculo;
        this.cambioAceite = cambioAceite;
        this.activo = activo;
    }

    public List<CambioAceite> getCambioAceite() {
        return cambioAceite;
    }

    public void setCambioAceite(List<CambioAceite> cambioAceite) {
        this.cambioAceite = cambioAceite;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<ServicioRealizado> getServicioRealizado() {
        return servicioRealizado;
    }

    public void setServicioRealizado(List<ServicioRealizado> servicioRealizado) {
        this.servicioRealizado = servicioRealizado;
    }

    public List<ControlKilometraje> getControlKilometraje() {
        return controlKilometraje;
    }

    public void setControlKilometraje(List<ControlKilometraje> controlKilometraje) {
        this.controlKilometraje = controlKilometraje;
    }

    public List<AsignacionVehiculo> getAsignacionVehiculo() {
        return asignacionVehiculo;
    }

    public void setAsignacionVehiculo(List<AsignacionVehiculo> asignacionVehiculo) {
        this.asignacionVehiculo = asignacionVehiculo;
    }
}
