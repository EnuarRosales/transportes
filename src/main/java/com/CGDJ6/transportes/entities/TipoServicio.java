package com.CGDJ6.transportes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TipoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String descripcion;


    public TipoServicio() {
    }

    public TipoServicio(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
