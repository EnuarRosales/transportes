package com.CGDJ6.transportes.entities;


import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity

public class Vehiculo implements Serializable {
    private  static final  long serialVersionUID =1L;
    @Id
    private String placa;

    @ManyToOne
    @JoinColumn(name = "tipo_vehiculo_id")
    private  TipoVehiculo tipoVehiculo;

    private  Integer modelo;

    private  String marca;




}
