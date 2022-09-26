package com.CGDJ6.transportes.entities;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Data
@Entity
public class AsignacionVehiculo /*implements Serializable*/ {

    //private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "usuario_cedula")
    private  Usuario usuario;

    private String fechaAsignacion;

    private String unidad;

    public AsignacionVehiculo() {
    }

    public AsignacionVehiculo(Long id, Vehiculo vehiculo, Usuario usuario, String fechaAsignacion, String unidad) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        this.fechaAsignacion = fechaAsignacion;
        this.unidad = unidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
