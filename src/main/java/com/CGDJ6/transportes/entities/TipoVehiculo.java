package com.CGDJ6.transportes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//@Data
@Entity
public class TipoVehiculo /*implements Serializable*/{
    //private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoVehiculo")
    private List<Vehiculo> vehiculo;

    private boolean activo =true;

    public TipoVehiculo() {
    }

    public TipoVehiculo(Long id, String descripcion, List<Vehiculo> vehiculo, boolean activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.vehiculo = vehiculo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(List<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
    }
}
