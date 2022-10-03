package com.CGDJ6.transportes.entities;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.hibernate.type.TrueFalseType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@Data
@Entity
public class ControlKilometraje /*implements Serializable*/ {
    //private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")
    private Vehiculo vehiculo;

    private String fechaRegistro;

    private  Long  kilometraje;

    private  Long kilometrajePorConsumir =0L;

    private boolean activo = true;

    public ControlKilometraje() {

    }

    public ControlKilometraje(Long id, Vehiculo vehiculo, String fechaRegistro, Long kilometraje, Long kilometrajePorConsumir, boolean activo) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.fechaRegistro = fechaRegistro;
        this.kilometraje = kilometraje;
        this.kilometrajePorConsumir = kilometrajePorConsumir;
        this.activo = activo;
    }

    public Long getKilometrajePorConsumir() {
        return kilometrajePorConsumir;
    }

    public void setKilometrajePorConsumir(Long kilometrajePorConsumir) {
        this.kilometrajePorConsumir = kilometrajePorConsumir;
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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Long kilometraje) {
        this.kilometraje = kilometraje;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
