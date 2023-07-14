package com.api.PROY_SALUD_RESTAPI_SPRING.service;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Doctores;
import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Pacientes;
import com.api.PROY_SALUD_RESTAPI_SPRING.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacientesService {
    @Autowired
    PacientesRepository pacientesRepository;
    public List<Pacientes> getPacientes(){
        return  pacientesRepository.findAll();
    }

    public Optional<Pacientes> getPaciente(Long id_paciente){
        return pacientesRepository.findById(id_paciente);
    }

    public List<Pacientes> getPacientesByCedula(String numero_cedula) {
        return pacientesRepository.findByCedula(numero_cedula);
    }
    public Pacientes saveOrUpdate(Pacientes pacientes){
        return pacientesRepository.save(pacientes);
    }

    public void delete(Long id_paciente){
        pacientesRepository.deleteById(id_paciente);
    }
}
