package com.api.PROY_SALUD_RESTAPI_SPRING.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "citas_medicas")
public class CitasMedicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cita;
    private Long id_doctor;
    private Long id_paciente;
    private Long especialidad;
    private Date fecha;
    private boolean disponibilidad;
}
