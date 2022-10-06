package com.CGDJ6.transportes.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Columns;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    private  String modelo;

    private  String marca;

    private  String color;

    private  Integer anoVehiculo;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaExpiracionSeguro;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  Date fechaExpiracionTecnomecanica;


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

    public Vehiculo(String placa, TipoVehiculo tipoVehiculo, String modelo, String marca, String color, Integer anoVehiculo, Date fechaExpiracionSeguro, Date fechaExpiracionTecnomecanica, String imagen, List<ServicioRealizado> servicioRealizado, List<ControlKilometraje> controlKilometraje, List<AsignacionVehiculo> asignacionVehiculo, List<CambioAceite> cambioAceite, boolean activo) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.anoVehiculo = anoVehiculo;
        this.fechaExpiracionSeguro = fechaExpiracionSeguro;
        this.fechaExpiracionTecnomecanica = fechaExpiracionTecnomecanica;
        this.imagen = imagen;
        this.servicioRealizado = servicioRealizado;
        this.controlKilometraje = controlKilometraje;
        this.asignacionVehiculo = asignacionVehiculo;
        this.cambioAceite = cambioAceite;
        this.activo = activo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAnoVehiculo() {
        return anoVehiculo;
    }

    public void setAnoVehiculo(Integer anoVehiculo) {
        this.anoVehiculo = anoVehiculo;
    }

    public Date getFechaExpiracionSeguro() {
        return fechaExpiracionSeguro;
    }

    public void setFechaExpiracionSeguro(Date fechaExpiracionSeguro) {
        this.fechaExpiracionSeguro = fechaExpiracionSeguro;
    }

    public Date getFechaExpiracionTecnomecanica() {
        return fechaExpiracionTecnomecanica;
    }

    public void setFechaExpiracionTecnomecanica(Date fechaExpiracionTecnomecanica) {
        this.fechaExpiracionTecnomecanica = fechaExpiracionTecnomecanica;
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
