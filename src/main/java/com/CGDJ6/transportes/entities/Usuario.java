package com.CGDJ6.transportes.entities;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    private Long cedula;
    //@Column(name = "tipoUsuario_id")
    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario usuario;

    private  String grado;

    private  String nombre;

    public Usuario() {
    }

    public Usuario(Long cedula, TipoUsuario usuario, String grado, String nombre) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.grado = grado;
        this.nombre = nombre;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TipoUsuario usuario) {
        this.usuario = usuario;
    }

}
