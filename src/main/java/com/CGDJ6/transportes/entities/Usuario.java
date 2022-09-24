package com.CGDJ6.transportes.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
public class Usuario implements Serializable {
    private  static final  long serialVersionUID =1L;
    @Id
    private Long cedula;
    //@Column(name = "tipoUsuario_id")
    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario usuario;

    private  String grado;

    private  String nombre;


}
