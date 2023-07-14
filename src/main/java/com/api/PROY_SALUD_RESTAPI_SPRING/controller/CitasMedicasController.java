package com.api.PROY_SALUD_RESTAPI_SPRING.controller;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.*;
import com.api.PROY_SALUD_RESTAPI_SPRING.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/citasmedicas")
public class CitasMedicasController {
    @Autowired
    private CitasMedicasTodoService citasMedicasTodoService;
    @Autowired
    private CitasMedicasService citasMedicasService;
    @Autowired
    private DoctoresService doctoresService;
    @Autowired
    private EspecialidadesService especialidadesService;
    @Autowired
    private PacientesService pacientesService;

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAll() {
        List<CitasMedicasTodo> citasMedicas = citasMedicasTodoService.getCitasMedicasTodo();
        List<Especialidades> especialidades = especialidadesService.getEspecialidades();
        Map<String, Object> response = new HashMap<>();
        response.put("citasMedicas", citasMedicas);
        response.put("especialidades", especialidades);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id_cita}")
    public ResponseEntity<?> getBId(@PathVariable("id_cita") Long id_cita){
        Optional<CitasMedicasTodo> citamedica = citasMedicasTodoService.getCitaMedicaTodo(id_cita);
        if (citamedica.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("cita_medica", citamedica.get());
            return ResponseEntity.ok(response);
        } else {
            String errorMessage = "No Existe el cita medica con Id: "+id_cita;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }
    @GetMapping("/crear/{especia}")
    public ResponseEntity<?> crear(@PathVariable("especia") String especia){
        if(especia.equals("n")){
            List<Especialidades> especialidades= especialidadesService.getEspecialidades();
            List<Doctores> doctoresEs=null;
            Map<String, Object> response = new HashMap<>();
            response.put("especialidades", especialidades);
            response.put("doctores", doctoresEs);
            return ResponseEntity.ok(response);
        }else{
            List<Doctores> doctoresEs=doctoresService.getDoctoresByEspecialidad(Long.parseLong(especia));
            List<Especialidades> especialidades=null;
            Map<String, Object> response = new HashMap<>();
            response.put("especialidades", especialidades);
            response.put("doctores", doctoresEs);
            return ResponseEntity.ok(response);
        }
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody CitaMedicaPost citaMedicaPost) {
        try {

            if(citaMedicaPost.getNumero_cedula()==null){
                CitasMedicas newCitaMedica = new CitasMedicas();
                newCitaMedica.setId_paciente(null);
                newCitaMedica.setEspecialidad(citaMedicaPost.getId_especialidad());
                newCitaMedica.setId_doctor(citaMedicaPost.getId_doctor());
                newCitaMedica.setFecha(citaMedicaPost.getFecha());
                newCitaMedica.setDisponibilidad(true);
                CitasMedicas citasMedica = citasMedicasService.saveOrUpdate(newCitaMedica);
                return new ResponseEntity<>(citasMedica, HttpStatus.CREATED);
            }else{
                List<Pacientes> pacientes = pacientesService.getPacientesByCedula(citaMedicaPost.getNumero_cedula());
                if (!pacientes.isEmpty()) {
                    Pacientes primerPaciente = pacientes.get(0);
                    CitasMedicas newCitaMedica = new CitasMedicas();
                    newCitaMedica.setId_paciente(primerPaciente.getId_paciente());
                    newCitaMedica.setEspecialidad(citaMedicaPost.getId_especialidad());
                    newCitaMedica.setId_doctor(citaMedicaPost.getId_doctor());
                    newCitaMedica.setFecha(citaMedicaPost.getFecha());
                    newCitaMedica.setDisponibilidad(false);
                    CitasMedicas citasMedica = citasMedicasService.saveOrUpdate(newCitaMedica);
                    return new ResponseEntity<>(citasMedica, HttpStatus.CREATED);
                } else {
                    String errorMessage = "No existe un paciente con esa cédula: " + citaMedicaPost.getNumero_cedula();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body(errorMessage);
                }
            }
        } catch (Exception e) {
            String errorMessage = "Ocurrió un error al guardar el Cita Medica";
            String error=e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error);
        }
    }

}
