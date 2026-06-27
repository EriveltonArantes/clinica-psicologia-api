package com.clinicapsicologiaapi.dto;

public class EvolucaoResponseDTO {

    private Long id;
    private Long pacienteId;
    private Long psicologoId;
    private Long dataSessaoId;
    private String descricao;
    private String humor;
    private String progresso;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
