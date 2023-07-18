package com.api.PROY_SALUD_RESTAPI_SPRING.controller;
import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Pacientes;
import com.api.PROY_SALUD_RESTAPI_SPRING.service.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/pacientes")
public class PacientesController {

    @Autowired
    private PacientesService pacientesService;


    @GetMapping()
    public List<Pacientes> getAll(){
        return pacientesService.getPacientes();

    }

    @GetMapping("/{id_paciente}")
    public ResponseEntity<?> getBId(@PathVariable("id_paciente") Long id_paciente){
        Optional<Pacientes> paciente = pacientesService.getPaciente(id_paciente);
        if (paciente.isPresent()) {
            return ResponseEntity.ok(paciente);
        } else {
            String errorMessage = "No Existe el paciente con Id: "+id_paciente;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }

    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Pacientes pacientes) {
        try {
            Pacientes nuevo_Paciente = pacientesService.saveOrUpdate(pacientes);
            return new ResponseEntity<>(nuevo_Paciente, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMessage = "Ocurrió un error al guardar el paciente";
            String error = e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error);
        }
    }
    @PutMapping("/{id_paciente}")
    public ResponseEntity<?> saveUpdate(@PathVariable("id_paciente") Long id_paciente, @RequestBody Pacientes paciente) {
        try {
            Optional<Pacientes> pacienteOptional = pacientesService.getPaciente(id_paciente);
            if (pacienteOptional.isPresent()) {
                Pacientes pacienteId = pacienteOptional.get();

                // Formatear Fecha de nacimiento
                Date fechaNacimientoStr = paciente.getFecha_nacimiento();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                LocalDate fechaNacimiento = LocalDate.parse(dateFormat.format(fechaNacimientoStr), formatter);
                LocalDate fechaNacimientoMasUnDia = fechaNacimiento.plusDays(1);
                Date fechaNacimientoMasUnDiaUtil = java.sql.Date.valueOf(fechaNacimientoMasUnDia);
                pacienteId.setFecha_nacimiento(fechaNacimientoMasUnDiaUtil);

                pacienteId.setNombre(paciente.getNombre());
                pacienteId.setApellido(paciente.getApellido());
                pacienteId.setNumero_cedula(paciente.getNumero_cedula());
                pacienteId.setTelefono(paciente.getTelefono());
                Pacientes pacienteUpdated = pacientesService.saveOrUpdate(pacienteId);
                return new ResponseEntity<>(pacienteUpdated, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            String errorMessage = "Ocurrió un error al Actualizar el paciente";
            String[] error = e.getMessage().split("]");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error[0] + "]");
        }
    }
    @DeleteMapping("/{id_paciente}")
    public ResponseEntity<HashMap<String, Boolean>> delete(@PathVariable Long id_paciente) {
        Optional<Pacientes> paciente = pacientesService.getPaciente(id_paciente);
        if (paciente.isPresent()) {
            this.pacientesService.delete(id_paciente);
            HashMap<String, Boolean> estadoPacienteEliminado = new HashMap<>();
            estadoPacienteEliminado.put("Eliminado", true);
            return ResponseEntity.ok(estadoPacienteEliminado);
        } else {
            HashMap<String, Boolean> estadoPacienteEliminado = new HashMap<>();
            String errorMessage = "No Existe el paciente con Id: "+id_paciente;
            estadoPacienteEliminado.put(errorMessage,false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(estadoPacienteEliminado);

        }
    }

}
