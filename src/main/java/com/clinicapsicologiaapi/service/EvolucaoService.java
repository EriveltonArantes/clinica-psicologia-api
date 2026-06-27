package com.clinicapsicologiaapi.service;

import com.clinicapsicologiaapi.dto.EvolucaoRequestDTO;
import com.clinicapsicologiaapi.dto.EvolucaoResponseDTO;
import com.clinicapsicologiaapi.exception.ResourceNotFoundException;
import com.clinicapsicologiaapi.mapper.EvolucaoMapper;
import com.clinicapsicologiaapi.model.Evolucao;
import com.clinicapsicologiaapi.repository.EvolucaoRepository;
import com.clinicapsicologiaapi.repository.PacienteRepository;
import com.clinicapsicologiaapi.model.Paciente;
import com.clinicapsicologiaapi.repository.PsicologoRepository;
import com.clinicapsicologiaapi.model.Psicologo;
import com.clinicapsicologiaapi.repository.SessaoRepository;
import com.clinicapsicologiaapi.model.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EvolucaoService {

    @Autowired
    private EvolucaoRepository repository;

    @Autowired
    private EvolucaoMapper mapper;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PsicologoRepository psicologoRepository;

    @Autowired
    private SessaoRepository dataSessaoRepository;

    @Transactional(readOnly = true)
    public List<EvolucaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EvolucaoResponseDTO buscar(Long id) {
        Evolucao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Evolucao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public EvolucaoResponseDTO criar(EvolucaoRequestDTO dto) {
        Evolucao entity = mapper.toEntity(dto);
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getPacienteId()));
        entity.setPaciente(paciente);
        Psicologo psicologo = psicologoRepository.findById(dto.getPsicologoId())
            .orElseThrow(() -> new ResourceNotFoundException("Psicologo não encontrado com id: " + dto.getPsicologoId()));
        entity.setPsicologo(psicologo);
        Sessao dataSessao = dataSessaoRepository.findById(dto.getDataSessaoId())
            .orElseThrow(() -> new ResourceNotFoundException("Sessao não encontrado com id: " + dto.getDataSessaoId()));
        entity.setDataSessao(dataSessao);
        Evolucao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public EvolucaoResponseDTO atualizar(Long id, EvolucaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Evolucao não encontrado com id: " + id);
        }
        Evolucao entity = mapper.toEntity(dto);
        entity.setId(id);
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getPacienteId()));
        entity.setPaciente(paciente);
        Psicologo psicologo = psicologoRepository.findById(dto.getPsicologoId())
            .orElseThrow(() -> new ResourceNotFoundException("Psicologo não encontrado com id: " + dto.getPsicologoId()));
        entity.setPsicologo(psicologo);
        Sessao dataSessao = dataSessaoRepository.findById(dto.getDataSessaoId())
            .orElseThrow(() -> new ResourceNotFoundException("Sessao não encontrado com id: " + dto.getDataSessaoId()));
        entity.setDataSessao(dataSessao);
        Evolucao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Evolucao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
