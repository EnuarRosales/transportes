package com.CGDJ6.transportes.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Data
@Entity
public class ServicioRealizado /*implements Serializable*/ {
    //private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_servicio_id")
    private TipoServicio tipoServicio;

    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")
    private Vehiculo vehiculo;

    private String fechaInicioServicio;

    private  String fechaTerminoServicio;

    private Long kilometrajeInicio;

    private Long kilometrajeTermino;

    private  String descripcion;

    private boolean activo =true;

    public ServicioRealizado() {
    }

    public ServicioRealizado(Long id, TipoServicio tipoServicio, Vehiculo vehiculo, String fechaInicioServicio, String fechaTerminoServicio, Long kilometrajeInicio, Long kilometrajeTermino, String descripcion, boolean activo) {
        this.id = id;
        this.tipoServicio = tipoServicio;
        this.vehiculo = vehiculo;
        this.fechaInicioServicio = fechaInicioServicio;
        this.fechaTerminoServicio = fechaTerminoServicio;
        this.kilometrajeInicio = kilometrajeInicio;
        this.kilometrajeTermino = kilometrajeTermino;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFechaInicioServicio() {
        return fechaInicioServicio;
    }

    public void setFechaInicioServicio(String fechaInicioServicio) {
        this.fechaInicioServicio = fechaInicioServicio;
    }

    public String getFechaTerminoServicio() {
        return fechaTerminoServicio;
    }

    public void setFechaTerminoServicio(String fechaTerminoServicio) {
        this.fechaTerminoServicio = fechaTerminoServicio;
    }

    public Long getKilometrajeInicio() {
        return kilometrajeInicio;
    }

    public void setKilometrajeInicio(Long kilometrajeInicio) {
        this.kilometrajeInicio = kilometrajeInicio;
    }

    public Long getKilometrajeTermino() {
        return kilometrajeTermino;
    }

    public void setKilometrajeTermino(Long kilometrajeTermino) {
        this.kilometrajeTermino = kilometrajeTermino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
