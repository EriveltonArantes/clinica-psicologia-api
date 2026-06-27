package com.clinicapsicologiaapi.mapper;

import com.clinicapsicologiaapi.dto.EvolucaoRequestDTO;
import com.clinicapsicologiaapi.dto.EvolucaoResponseDTO;
import com.clinicapsicologiaapi.model.Evolucao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EvolucaoMapper {

    @Mapping(target = "paciente", ignore = true)
    @Mapping(target = "psicologo", ignore = true)
    @Mapping(target = "dataSessao", ignore = true)
    Evolucao toEntity(EvolucaoRequestDTO dto);

    @Mapping(target = "pacienteId", source = "paciente.id")
    @Mapping(target = "psicologoId", source = "psicologo.id")
    @Mapping(target = "dataSessaoId", source = "dataSessao.id")
    EvolucaoResponseDTO toResponseDTO(Evolucao entity);
}
