package com.clinicapsicologiaapi.mapper;

import com.clinicapsicologiaapi.dto.PsicologoRequestDTO;
import com.clinicapsicologiaapi.dto.PsicologoResponseDTO;
import com.clinicapsicologiaapi.model.Psicologo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PsicologoMapper {

    @Mapping(target = "idPaciente", ignore = true)
    Psicologo toEntity(PsicologoRequestDTO dto);

    @Mapping(target = "idPacienteId", source = "idPaciente.id")
    PsicologoResponseDTO toResponseDTO(Psicologo entity);
}
