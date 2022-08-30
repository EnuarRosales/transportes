package com.CGDJ6.transportes.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ControlKilometraje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")
    private Vehiculo vehiculo;

    private Date fechaRegistro;

    private  Long  kilometraje;


    public ControlKilometraje() {
    }

    public ControlKilometraje(Vehiculo vehiculo, Date fechaRegistro, Long kilometraje) {
        this.vehiculo = vehiculo;
        this.fechaRegistro = fechaRegistro;
        this.kilometraje = kilometraje;
    }

    public Long getId() {
        return id;
    }


    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Long kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}
