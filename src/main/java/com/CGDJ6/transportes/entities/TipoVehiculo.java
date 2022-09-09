package com.CGDJ6.transportes.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TipoVehiculo {
    private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String descripcion;


}
