package com.clinicapsicologiaapi.repository;

import com.clinicapsicologiaapi.model.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
}
