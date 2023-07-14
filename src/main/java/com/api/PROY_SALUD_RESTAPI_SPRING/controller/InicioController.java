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
        message += "- /api/pacientes\n";
        message += "- /api/doctores\n";
        // Agrega aquí otras rutas de tu API

        return message;
    }
}
