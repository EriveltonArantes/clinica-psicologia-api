package com.clinicapsicologiaapi.repository;

import com.clinicapsicologiaapi.model.Evolucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvolucaoRepository extends JpaRepository<Evolucao, Long> {
}
