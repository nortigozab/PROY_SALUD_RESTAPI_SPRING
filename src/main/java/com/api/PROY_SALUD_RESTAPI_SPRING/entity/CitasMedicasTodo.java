package com.api.PROY_SALUD_RESTAPI_SPRING.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "citas_medicas")
public class CitasMedicasTodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cita;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_doctor")
    private DoctoresEspecialidad doctor;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paciente")
    private Pacientes paciente;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "especialidad")
    private Especialidades especialidad;
    private Date fecha;
    private Boolean disponibilidad;
}
