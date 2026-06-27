package com.clinicapsicologiaapi.controller;

import com.clinicapsicologiaapi.dto.PacienteRequestDTO;
import com.clinicapsicologiaapi.dto.PacienteResponseDTO;
import com.clinicapsicologiaapi.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Paciente", description = "Gerenciamento de pacientes")
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @Operation(summary = "Listar todos os Paciente")
    @GetMapping
    public List<PacienteResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<PacienteResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Paciente por ID")
    @GetMapping("/{id}")
    public PacienteResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Paciente")
    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criar(@Valid @RequestBody PacienteRequestDTO paciente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(paciente));
    }

    @Operation(summary = "Atualizar Paciente")
    @PutMapping("/{id}")
    public PacienteResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PacienteRequestDTO paciente) {
        return service.atualizar(id, paciente);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Paciente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
