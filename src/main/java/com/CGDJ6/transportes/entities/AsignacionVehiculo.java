package com.CGDJ6.transportes.entities;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class AsignacionVehiculo implements Serializable {

    private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "usuario_cedula")
    private  Usuario usuario;

    private String fechaAsignacion;

    private String unidad;

}
