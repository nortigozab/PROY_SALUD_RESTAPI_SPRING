package com.api.PROY_SALUD_RESTAPI_SPRING.service;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Especialidades;
import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Pacientes;
import com.api.PROY_SALUD_RESTAPI_SPRING.repository.EspecialidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadesService {
    @Autowired
    EspecialidadesRepository especialidadesRepository;

    public List<Especialidades> getEspecialidades(){
        return especialidadesRepository.findAll();
    }
}
