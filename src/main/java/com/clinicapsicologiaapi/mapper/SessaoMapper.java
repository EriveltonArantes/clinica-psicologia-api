package com.clinicapsicologiaapi.mapper;

import com.clinicapsicologiaapi.dto.SessaoRequestDTO;
import com.clinicapsicologiaapi.dto.SessaoResponseDTO;
import com.clinicapsicologiaapi.model.Sessao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SessaoMapper {

    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "psicologo", ignore = true)
    Sessao toEntity(SessaoRequestDTO dto);

    @Mapping(target = "pacienteId", source = "paciente.id")
    @Mapping(target = "psicologoId", source = "psicologo.id")
    SessaoResponseDTO toResponseDTO(Sessao entity);
}
