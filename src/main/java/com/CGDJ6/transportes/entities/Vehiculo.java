package com.CGDJ6.transportes.entities;


import javax.persistence.*;

@Entity
public class Vehiculo {

    @Id
    private String placa;

    @ManyToOne
    @JoinColumn(name = "tipo_vehiculo_id")
    private  TipoVehiculo tipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "usuario_cedula")
    private  Usuario usuario;

    private  Integer modelo;

    private  String marca;


    public Vehiculo() {
    }

    public Vehiculo(String placa, TipoVehiculo tipoVehiculo, Usuario usuario, Integer modelo, String marca) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.usuario = usuario;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }


}
