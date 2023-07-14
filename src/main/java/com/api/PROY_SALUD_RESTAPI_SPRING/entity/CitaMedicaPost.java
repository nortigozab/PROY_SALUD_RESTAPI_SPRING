package com.api.PROY_SALUD_RESTAPI_SPRING.entity;

import jakarta.persistence.Entity;

import java.util.Date;
public class CitaMedicaPost {
    private String numero_cedula;
    private Long id_especialidad;
    private long id_doctor;
    private Date fecha;

    public String getNumero_cedula() {
        return numero_cedula;
    }

    public void setNumero_cedula(String numero_cedula) {
        this.numero_cedula = numero_cedula;
    }

    public Long getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(Long id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(long id_doctor) {
        this.id_doctor = id_doctor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
