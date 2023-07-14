package com.api.PROY_SALUD_RESTAPI_SPRING.service;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.CitasMedicasTodo;
import com.api.PROY_SALUD_RESTAPI_SPRING.entity.DoctoresEspecialidad;
import com.api.PROY_SALUD_RESTAPI_SPRING.repository.CitasMedicasTodoRepository;
import com.api.PROY_SALUD_RESTAPI_SPRING.repository.DoctoresEspeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitasMedicasTodoService {
    @Autowired
    CitasMedicasTodoRepository citasMedicasTodoRepository;

    public List<CitasMedicasTodo> getCitasMedicasTodo(){
        return citasMedicasTodoRepository.findAll();
    }
    public Optional<CitasMedicasTodo> getCitaMedicaTodo(Long id_cita){
        return citasMedicasTodoRepository.findById(id_cita);
    }
}
