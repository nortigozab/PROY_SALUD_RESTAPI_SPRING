package com.api.PROY_SALUD_RESTAPI_SPRING.repository;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientesRepository  extends JpaRepository<Pacientes,Long> {
}
