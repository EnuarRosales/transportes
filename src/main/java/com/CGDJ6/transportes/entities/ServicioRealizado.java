package com.CGDJ6.transportes.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ServicioRealizado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_servicio_id")
    private TipoServicio tipoServicio;
    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")
    private Vehiculo vehiculo;
    private Date fechaInicioServicio;
    private  Date fechaTerminoServicio;
    private Long kilometrajeInicio;
    private Long kilometrajeTermino;

    private  String descripcion;


    public ServicioRealizado() {
    }

    public ServicioRealizado(TipoServicio tipoServicio, Vehiculo vehiculo, Date fechaInicioServicio, Date fechaTerminoServicio, Long kilometrajeInicio, Long kilometrajeTermino, String descripcion) {
        this.tipoServicio = tipoServicio;
        this.vehiculo = vehiculo;
        this.fechaInicioServicio = fechaInicioServicio;
        this.fechaTerminoServicio = fechaTerminoServicio;
        this.kilometrajeInicio = kilometrajeInicio;
        this.kilometrajeTermino = kilometrajeTermino;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }


    public Date getFechaInicioServicio() {
        return fechaInicioServicio;
    }

    public void setFechaInicioServicio(Date fechaInicioServicio) {
        this.fechaInicioServicio = fechaInicioServicio;
    }

    public Date getFechaTerminoServicio() {
        return fechaTerminoServicio;
    }

    public void setFechaTerminoServicio(Date fechaTerminoServicio) {
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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }




}
