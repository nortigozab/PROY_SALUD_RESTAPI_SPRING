package com.api.PROY_SALUD_RESTAPI_SPRING.repository;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.Doctores;
import com.api.PROY_SALUD_RESTAPI_SPRING.entity.DoctoresEspecialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctoresRepository extends JpaRepository<Doctores,Long> {
    @Query("SELECT d FROM Doctores d WHERE d.especialidad = ?1")
    List<Doctores> findByEspecialidad(Long idEspecialidad);
}
