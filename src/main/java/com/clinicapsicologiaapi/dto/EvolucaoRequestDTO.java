package com.clinicapsicologiaapi.dto;

import jakarta.validation.constraints.*;

public class EvolucaoRequestDTO {

    @NotNull(message = "PacienteId é obrigatório")
    @Positive(message = "PacienteId deve ser um ID válido (positivo)")
    private Long pacienteId;
    @NotNull(message = "PsicologoId é obrigatório")
    @Positive(message = "PsicologoId deve ser um ID válido (positivo)")
    private Long psicologoId;
    @NotNull(message = "DataSessaoId é obrigatório")
    @Positive(message = "DataSessaoId deve ser um ID válido (positivo)")
    private Long dataSessaoId;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotBlank(message = "humor não pode estar em branco")
    private String humor;
    @NotBlank(message = "progresso não pode estar em branco")
    private String progresso;

    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
    public Long getPsicologoId() { return psicologoId; }
    public void setPsicologoId(Long psicologoId) { this.psicologoId = psicologoId; }
    public Long getDataSessaoId() { return dataSessaoId; }
    public void setDataSessaoId(Long dataSessaoId) { this.dataSessaoId = dataSessaoId; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getHumor() { return humor; }
    public void setHumor(String humor) { this.humor = humor; }
    public String getProgresso() { return progresso; }
    public void setProgresso(String progresso) { this.progresso = progresso; }
}
