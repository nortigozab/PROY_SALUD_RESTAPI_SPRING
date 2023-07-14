package com.api.PROY_SALUD_RESTAPI_SPRING.service;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.DoctoresEspecialidad;
import com.api.PROY_SALUD_RESTAPI_SPRING.repository.DoctoresEspeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctoresEspeService {
    @Autowired
    DoctoresEspeRepository doctoresEspeRepository;

    public List<DoctoresEspecialidad> getDoctores(){
        return doctoresEspeRepository.findAll();
    }
    public Optional<DoctoresEspecialidad> getDoctorEspe(Long id_doctor){
        return doctoresEspeRepository.findById(id_doctor);
    }

}
