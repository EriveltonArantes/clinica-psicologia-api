package com.clinicapsicologiaapi.service;

import com.clinicapsicologiaapi.dto.PsicologoRequestDTO;
import com.clinicapsicologiaapi.dto.PsicologoResponseDTO;
import com.clinicapsicologiaapi.exception.ResourceNotFoundException;
import com.clinicapsicologiaapi.mapper.PsicologoMapper;
import com.clinicapsicologiaapi.model.Psicologo;
import com.clinicapsicologiaapi.repository.PsicologoRepository;
import com.clinicapsicologiaapi.repository.PacienteRepository;
import com.clinicapsicologiaapi.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PsicologoService {

    @Autowired
    private PsicologoRepository repository;

    @Autowired
    private PsicologoMapper mapper;

    @Autowired
    private PacienteRepository idPacienteRepository;

    @Transactional(readOnly = true)
    public List<PsicologoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PsicologoResponseDTO buscar(Long id) {
        Psicologo entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Psicologo não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public PsicologoResponseDTO criar(PsicologoRequestDTO dto) {
        Psicologo entity = mapper.toEntity(dto);
        Paciente idPaciente = idPacienteRepository.findById(dto.getIdPacienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getIdPacienteId()));
        entity.setIdPaciente(idPaciente);
        Psicologo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public PsicologoResponseDTO atualizar(Long id, PsicologoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Psicologo não encontrado com id: " + id);
        }
        Psicologo entity = mapper.toEntity(dto);
        entity.setId(id);
        Paciente idPaciente = idPacienteRepository.findById(dto.getIdPacienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getIdPacienteId()));
        entity.setIdPaciente(idPaciente);
        Psicologo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Psicologo não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
