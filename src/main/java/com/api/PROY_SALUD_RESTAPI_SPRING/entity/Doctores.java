package com.api.PROY_SALUD_RESTAPI_SPRING.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctores")
public class Doctores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_doctor;
    private String nombre;
    private String apellido;
    private Long especialidad;
    private int consultorio;
    private  String correo_contacto;
}
