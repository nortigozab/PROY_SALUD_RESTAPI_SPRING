package com.api.PROY_SALUD_RESTAPI_SPRING.repository;

import com.api.PROY_SALUD_RESTAPI_SPRING.entity.CitasMedicasTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitasMedicasTodoRepository extends JpaRepository<CitasMedicasTodo,Long> {
}
