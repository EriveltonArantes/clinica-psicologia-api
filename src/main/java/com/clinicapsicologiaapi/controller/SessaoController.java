package com.clinicapsicologiaapi.controller;

import com.clinicapsicologiaapi.dto.SessaoRequestDTO;
import com.clinicapsicologiaapi.dto.SessaoResponseDTO;
import com.clinicapsicologiaapi.service.SessaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Sessao", description = "Gerenciamento de sessaos")
@RestController
@RequestMapping("/api/sessaos")
public class SessaoController {

    @Autowired
    private SessaoService service;

    @Operation(summary = "Listar todos os Sessao")
    @GetMapping
    public List<SessaoResponseDTO> listar(@RequestParam(required = false) String modalidade, @RequestParam(required = false) Long pacienteId, @RequestParam(required = false) Long psicologoId) {
        List<SessaoResponseDTO> resultado = service.listar();
        if (modalidade != null && !modalidade.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getModalidade() != null &&
                item.getModalidade().toLowerCase().contains(modalidade.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (pacienteId != null) {
            resultado = resultado.stream().filter(item -> pacienteId.equals(item.getPacienteId())).collect(java.util.stream.Collectors.toList());
        }
        if (psicologoId != null) {
            resultado = resultado.stream().filter(item -> psicologoId.equals(item.getPsicologoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Sessao por ID")
    @GetMapping("/{id}")
    public SessaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Sessao")
    @PostMapping
    public ResponseEntity<SessaoResponseDTO> criar(@Valid @RequestBody SessaoRequestDTO sessao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(sessao));
    }

    @Operation(summary = "Atualizar Sessao")
    @PutMapping("/{id}")
    public SessaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody SessaoRequestDTO sessao) {
        return service.atualizar(id, sessao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Sessao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
