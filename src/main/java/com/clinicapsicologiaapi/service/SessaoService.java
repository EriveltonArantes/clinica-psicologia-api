package com.clinicapsicologiaapi.service;

import com.clinicapsicologiaapi.dto.SessaoRequestDTO;
import com.clinicapsicologiaapi.dto.SessaoResponseDTO;
import com.clinicapsicologiaapi.exception.ResourceNotFoundException;
import com.clinicapsicologiaapi.mapper.SessaoMapper;
import com.clinicapsicologiaapi.model.Sessao;
import com.clinicapsicologiaapi.repository.SessaoRepository;
import com.clinicapsicologiaapi.repository.PacienteRepository;
import com.clinicapsicologiaapi.model.Paciente;
import com.clinicapsicologiaapi.repository.PsicologoRepository;
import com.clinicapsicologiaapi.model.Psicologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SessaoService {

    @Autowired
    private SessaoRepository repository;

    @Autowired
    private SessaoMapper mapper;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PsicologoRepository psicologoRepository;

    @Transactional(readOnly = true)
    public List<SessaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SessaoResponseDTO buscar(Long id) {
        Sessao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Sessao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public SessaoResponseDTO criar(SessaoRequestDTO dto) {
        Sessao entity = mapper.toEntity(dto);
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getPacienteId()));
        entity.setPaciente(paciente);
        Psicologo psicologo = psicologoRepository.findById(dto.getPsicologoId())
            .orElseThrow(() -> new ResourceNotFoundException("Psicologo não encontrado com id: " + dto.getPsicologoId()));
        entity.setPsicologo(psicologo);
        Sessao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public SessaoResponseDTO atualizar(Long id, SessaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Sessao não encontrado com id: " + id);
        }
        Sessao entity = mapper.toEntity(dto);
        entity.setId(id);
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getPacienteId()));
        entity.setPaciente(paciente);
        Psicologo psicologo = psicologoRepository.findById(dto.getPsicologoId())
            .orElseThrow(() -> new ResourceNotFoundException("Psicologo não encontrado com id: " + dto.getPsicologoId()));
        entity.setPsicologo(psicologo);
        Sessao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Sessao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
