package com.api.PROY_SALUD_RESTAPI_SPRING.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctores")
public class DoctoresEspecialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_doctor;
    private String nombre;
    private String apellido;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "especialidad")
    private Especialidades especialidad;
    private int consultorio;
    private  String correo_contacto;
}
