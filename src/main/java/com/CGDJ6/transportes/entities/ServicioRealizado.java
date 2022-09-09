package com.CGDJ6.transportes.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class ServicioRealizado implements Serializable {
    private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_servicio_id")

    private TipoServicio tipoServicio;
    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")

    private Vehiculo vehiculo;

    private Date fechaInicioServicio;

    private  Date fechaTerminoServicio;

    private Long kilometrajeInicio;

    private Long kilometrajeTermino;

    private  String descripcion;



}
