package com.api.PROY_SALUD_RESTAPI_SPRING.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class InicioController {

    @GetMapping
    public String getRoot() {
        String message = "Bienvenido a la API de Salud\n\n";
        message += "Rutas disponibles:\n";
        message += "Get/Post - /api/pacientes\n";
        message += "Get/Put/Delete - /api/pacientes/id_paciente\n";
        message += "Get/Post - /api/doctores\n";
        message += "Get/Put/Delete - /api/doctores/id_doctor\n";
        message += " Get/Post - /api/citasmedicas\n";
        message += " Get - /api/citasmedicas/id_cita\n";
        message += " Get - /api/citasmedicas/crear/n 'Inicio para crear cita'\n";
        message += " Get - /api/citasmedicas/crear/id_especialidad 'Cambio de especialidad para ver doctores'\n";
        return message;
    }
}
