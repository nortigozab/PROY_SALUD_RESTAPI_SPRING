package com.api.PROY_SALUD_RESTAPI_SPRING.service;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.CitasMedicas;
import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Doctores;
import com.api.PROY_SALUD_RESTAPI_SPRING.repository.CitasMedicasRepository;
import com.api.PROY_SALUD_RESTAPI_SPRING.repository.DoctoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CitasMedicasService {
    @Autowired
    private CitasMedicasRepository citasMedicasRepository;
    public Optional<CitasMedicas> getCitaMedica(Long id_cita){
        return citasMedicasRepository.findById(id_cita);
    }
    public CitasMedicas saveOrUpdate(CitasMedicas citasMedicas){
        return citasMedicasRepository.save(citasMedicas);
    }
    public void delete(Long id_cita){
        citasMedicasRepository.deleteById(id_cita);
    }
}
