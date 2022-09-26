package com.CGDJ6.transportes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


//@Data
@Entity
public class TipoServicio /*implements Serializable*/ {
    //private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private  String descripcion;


    @JsonIgnore
    @OneToMany(mappedBy = "tipoServicio")
    private List<ServicioRealizado> servicioRealizado;


    public TipoServicio() {
    }

    public TipoServicio(Long id, String descripcion, List<ServicioRealizado> servicioRealizado) {
        this.id = id;
        this.descripcion = descripcion;
        this.servicioRealizado = servicioRealizado;
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

    public List<ServicioRealizado> getServicioRealizado() {
        return servicioRealizado;
    }

    public void setServicioRealizado(List<ServicioRealizado> servicioRealizado) {
        this.servicioRealizado = servicioRealizado;
    }
}
