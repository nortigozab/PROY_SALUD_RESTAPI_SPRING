package com.api.PROY_SALUD_RESTAPI_SPRING.controller;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Doctores;
import com.api.PROY_SALUD_RESTAPI_SPRING.entity.DoctoresEspecialidad;
import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Especialidades;
import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Pacientes;
import com.api.PROY_SALUD_RESTAPI_SPRING.service.DoctoresEspeService;
import com.api.PROY_SALUD_RESTAPI_SPRING.service.DoctoresService;
import com.api.PROY_SALUD_RESTAPI_SPRING.service.EspecialidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/doctores")
public class DoctoresController {
    @Autowired
    private DoctoresEspeService doctoresEspeService;
    @Autowired
    private DoctoresService doctoresService;
    @Autowired
    private EspecialidadesService especialidadesService;

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAll() {
        List<DoctoresEspecialidad> doctores = doctoresEspeService.getDoctores();
        List<Especialidades> especialidades = especialidadesService.getEspecialidades();

        Map<String, Object> response = new HashMap<>();
        response.put("doctores", doctores);
        response.put("especialidades", especialidades);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id_doctor}")
    public ResponseEntity<?> getBId(@PathVariable("id_doctor") Long id_doctor){
        Optional<DoctoresEspecialidad> doctor = doctoresEspeService.getDoctorEspe(id_doctor);
        List<Especialidades> especialidades = especialidadesService.getEspecialidades();
        if (doctor.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("doctor", doctor.get());
            response.put("especialidades", especialidades);
            return ResponseEntity.ok(response);
        } else {
            String errorMessage = "No Existe el doctor con Id: " + id_doctor;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Doctores doctores) {
        try {
            Doctores nuevo_Doctor = doctoresService.saveOrUpdate(doctores);
            return new ResponseEntity<>(nuevo_Doctor, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMessage = "Ocurrió un error al guardar el Doctor";
            String error=e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error);
        }
    }
    @PutMapping("/{id_doctor}")
    public ResponseEntity<?> saveUpdate(@PathVariable("id_doctor") Long id_doctor, @RequestBody Doctores doctores) {
        try {
            Optional<Doctores> doctorOptional = doctoresService.getDoctor(id_doctor);
            if (doctorOptional.isPresent()) {
                Doctores doctorId = doctorOptional.get();
                doctorId.setNombre(doctores.getNombre());
                doctorId.setApellido(doctores.getApellido());
                doctorId.setConsultorio(doctores.getConsultorio());
                doctorId.setEspecialidad(doctores.getEspecialidad());
                doctorId.setCorreo_contacto(doctores.getCorreo_contacto());
                Doctores doctorUpdated = doctoresService.saveOrUpdate(doctorId);
                return new ResponseEntity<>(doctorUpdated, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            String errorMessage = "Ocurrió un error al Actualizar el paciente";
            String[] error=e.getMessage().split("]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error[0]+"]");
        }

    }
    @DeleteMapping("/{id_doctor}")
    public ResponseEntity<HashMap<String, Boolean>> delete(@PathVariable Long id_doctor) {
        Optional<Doctores> doctor = doctoresService.getDoctor(id_doctor);
        if (doctor.isPresent()) {
            this.doctoresService.delete(id_doctor);
            HashMap<String, Boolean> estadoPacienteEliminado = new HashMap<>();
            estadoPacienteEliminado.put("Eliminado", true);
            return ResponseEntity.ok(estadoPacienteEliminado);
        } else {
            HashMap<String, Boolean> estadoPacienteEliminado = new HashMap<>();
            String errorMessage = "No Existe el doctor con Id: "+ id_doctor;
            estadoPacienteEliminado.put(errorMessage,false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(estadoPacienteEliminado);

        }
    }


}
