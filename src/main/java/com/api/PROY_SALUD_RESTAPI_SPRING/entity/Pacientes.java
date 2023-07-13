package com.api.PROY_SALUD_RESTAPI_SPRING.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "pacientes")
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente;
    private String nombre;
    private String apellido;
    private String numero_cedula;
    private Date fecha_nacimiento;
    private String telefono;

}
