package com.clinicapsicologiaapi.repository;

import com.clinicapsicologiaapi.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
}
