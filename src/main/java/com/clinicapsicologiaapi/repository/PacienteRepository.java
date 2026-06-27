package com.clinicapsicologiaapi.repository;

import com.clinicapsicologiaapi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
