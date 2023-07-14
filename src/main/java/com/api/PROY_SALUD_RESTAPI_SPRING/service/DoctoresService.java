package com.api.PROY_SALUD_RESTAPI_SPRING.service;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Doctores;
import com.api.PROY_SALUD_RESTAPI_SPRING.repository.DoctoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctoresService {
    @Autowired
    private DoctoresRepository doctoresRepository;
    public Optional<Doctores> getDoctor(Long id_doctor){
        return doctoresRepository.findById(id_doctor);
    }

    public List<Doctores> getDoctoresByEspecialidad(Long esspecialidad) {
        return doctoresRepository.findByEspecialidad(esspecialidad);
    }
    public Doctores saveOrUpdate(Doctores doctores){
        return doctoresRepository.save(doctores);
    }
    public void delete(Long id_doctor){
        doctoresRepository.deleteById(id_doctor);
    }
}
