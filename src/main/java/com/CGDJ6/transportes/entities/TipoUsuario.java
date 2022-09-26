package com.CGDJ6.transportes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

//@Data
@Entity
public class TipoUsuario /*implements Serializable*/ {
    //private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String descripcion;

    private boolean activo =true;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Usuario> usuario;


    public TipoUsuario() {
    }

    public TipoUsuario(Long id, String descripcion, boolean activo, List<Usuario> usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
        this.usuario = usuario;
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

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
}
