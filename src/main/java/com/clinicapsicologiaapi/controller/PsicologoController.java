package com.clinicapsicologiaapi.controller;

import com.clinicapsicologiaapi.dto.PsicologoRequestDTO;
import com.clinicapsicologiaapi.dto.PsicologoResponseDTO;
import com.clinicapsicologiaapi.service.PsicologoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Psicologo", description = "Gerenciamento de psicologos")
@RestController
@RequestMapping("/api/psicologos")
public class PsicologoController {

    @Autowired
    private PsicologoService service;

    @Operation(summary = "Listar todos os Psicologo")
    @GetMapping
    public List<PsicologoResponseDTO> listar(@RequestParam(required = false) String nome, @RequestParam(required = false) Long idPacienteId) {
        List<PsicologoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (idPacienteId != null) {
            resultado = resultado.stream().filter(item -> idPacienteId.equals(item.getIdPacienteId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Psicologo por ID")
    @GetMapping("/{id}")
    public PsicologoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Psicologo")
    @PostMapping
    public ResponseEntity<PsicologoResponseDTO> criar(@Valid @RequestBody PsicologoRequestDTO psicologo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(psicologo));
    }

    @Operation(summary = "Atualizar Psicologo")
    @PutMapping("/{id}")
    public PsicologoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PsicologoRequestDTO psicologo) {
        return service.atualizar(id, psicologo);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Psicologo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
