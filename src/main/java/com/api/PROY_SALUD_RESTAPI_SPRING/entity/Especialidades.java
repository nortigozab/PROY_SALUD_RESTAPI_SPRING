package com.api.PROY_SALUD_RESTAPI_SPRING.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "especialidades")
public class Especialidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_especialidad;
    private String nombre_especialidad;
}
