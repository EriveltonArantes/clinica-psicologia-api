package com.clinicapsicologiaapi.service;

import com.clinicapsicologiaapi.dto.PacienteRequestDTO;
import com.clinicapsicologiaapi.dto.PacienteResponseDTO;
import com.clinicapsicologiaapi.exception.ResourceNotFoundException;
import com.clinicapsicologiaapi.mapper.PacienteMapper;
import com.clinicapsicologiaapi.model.Paciente;
import com.clinicapsicologiaapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Autowired
    private PacienteMapper mapper;

    @Transactional(readOnly = true)
    public List<PacienteResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PacienteResponseDTO buscar(Long id) {
        Paciente entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public PacienteResponseDTO criar(PacienteRequestDTO dto) {
        Paciente entity = mapper.toEntity(dto);
        Paciente salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Paciente não encontrado com id: " + id);
        }
        Paciente entity = mapper.toEntity(dto);
        entity.setId(id);
        Paciente salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Paciente não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
