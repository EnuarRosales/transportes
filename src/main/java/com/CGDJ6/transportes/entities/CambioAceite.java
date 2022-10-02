package com.CGDJ6.transportes.entities;


import javax.persistence.*;

@Entity
public class CambioAceite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")
    private  Vehiculo vehiculo;

    private String fechaCambioAceite;

    private  Integer kilometrajeCambioAceite;


    private boolean activo =true;


    public CambioAceite() {
    }


    public CambioAceite(Long id, Vehiculo vehiculo, String fechaCambioAceite, Integer kilometrajeCambioAceite, boolean activo) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.fechaCambioAceite = fechaCambioAceite;
        this.kilometrajeCambioAceite = kilometrajeCambioAceite;
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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFechaCambioAceite() {
        return fechaCambioAceite;
    }

    public void setFechaCambioAceite(String fechaCambioAceite) {
        this.fechaCambioAceite = fechaCambioAceite;
    }

    public Integer getKilometrajeCambioAceite() {
        return kilometrajeCambioAceite;
    }

    public void setKilometrajeCambioAceite(Integer kilometrajeCambioAceite) {
        this.kilometrajeCambioAceite = kilometrajeCambioAceite;
    }
}
