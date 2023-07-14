package com.api.PROY_SALUD_RESTAPI_SPRING.repository;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Doctores;
import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacientesRepository  extends JpaRepository<Pacientes,Long> {
    @Query("SELECT p FROM Pacientes p WHERE p.numero_cedula = ?1")
    List<Pacientes> findByCedula(String numero_cedula);
}
