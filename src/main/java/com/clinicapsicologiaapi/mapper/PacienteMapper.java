package com.clinicapsicologiaapi.mapper;

import com.clinicapsicologiaapi.dto.PacienteRequestDTO;
import com.clinicapsicologiaapi.dto.PacienteResponseDTO;
import com.clinicapsicologiaapi.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    Paciente toEntity(PacienteRequestDTO dto);

    PacienteResponseDTO toResponseDTO(Paciente entity);
}
