package com.CGDJ6.transportes.entities;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class ControlKilometraje implements Serializable {
    private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")
    private Vehiculo vehiculo;

    private String fechaRegistro;

    private  Long  kilometraje;


}
