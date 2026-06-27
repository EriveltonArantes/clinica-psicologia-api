package com.clinicapsicologiaapi.controller;

import com.clinicapsicologiaapi.dto.EvolucaoRequestDTO;
import com.clinicapsicologiaapi.dto.EvolucaoResponseDTO;
import com.clinicapsicologiaapi.service.EvolucaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Evolucao", description = "Gerenciamento de evolucaos")
@RestController
@RequestMapping("/api/evolucaos")
public class EvolucaoController {

    @Autowired
    private EvolucaoService service;

    @Operation(summary = "Listar todos os Evolucao")
    @GetMapping
    public List<EvolucaoResponseDTO> listar(@RequestParam(required = false) String descricao, @RequestParam(required = false) Long pacienteId, @RequestParam(required = false) Long psicologoId, @RequestParam(required = false) Long dataSessaoId) {
        List<EvolucaoResponseDTO> resultado = service.listar();
        if (descricao != null && !descricao.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getDescricao() != null &&
                item.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (pacienteId != null) {
            resultado = resultado.stream().filter(item -> pacienteId.equals(item.getPacienteId())).collect(java.util.stream.Collectors.toList());
        }
        if (psicologoId != null) {
            resultado = resultado.stream().filter(item -> psicologoId.equals(item.getPsicologoId())).collect(java.util.stream.Collectors.toList());
        }
        if (dataSessaoId != null) {
            resultado = resultado.stream().filter(item -> dataSessaoId.equals(item.getDataSessaoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Evolucao por ID")
    @GetMapping("/{id}")
    public EvolucaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Evolucao")
    @PostMapping
    public ResponseEntity<EvolucaoResponseDTO> criar(@Valid @RequestBody EvolucaoRequestDTO evolucao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(evolucao));
    }

    @Operation(summary = "Atualizar Evolucao")
    @PutMapping("/{id}")
    public EvolucaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody EvolucaoRequestDTO evolucao) {
        return service.atualizar(id, evolucao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Evolucao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
