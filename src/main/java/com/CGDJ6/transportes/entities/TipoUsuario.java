package com.CGDJ6.transportes.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class TipoUsuario implements Serializable {
    private  static final  long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private  String descripcion;


}
