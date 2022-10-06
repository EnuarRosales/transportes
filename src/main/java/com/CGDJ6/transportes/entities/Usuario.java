package com.CGDJ6.transportes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



@Entity
public class Usuario /*implements Serializable*/ {
    //private  static final  long serialVersionUID =1L;
    @Id
    private Long cedula;
    //@Column(name = "tipoUsuario_id")

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario usuario;

    private  String grado;

    private  String nombre;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expiracioLicenciaConduccion;

    private boolean activo =true;


    public Usuario() {
    }


    public Usuario(Long cedula, TipoUsuario usuario, String grado, String nombre, Date expiracioLicenciaConduccion, boolean activo) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.grado = grado;
        this.nombre = nombre;
        this.expiracioLicenciaConduccion = expiracioLicenciaConduccion;
        this.activo = activo;
    }

    public Date getExpiracioLicenciaConduccion() {
        return expiracioLicenciaConduccion;
    }

    public void setExpiracioLicenciaConduccion(Date expiracioLicenciaConduccion) {
        this.expiracioLicenciaConduccion = expiracioLicenciaConduccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public TipoUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TipoUsuario usuario) {
        this.usuario = usuario;
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
}
