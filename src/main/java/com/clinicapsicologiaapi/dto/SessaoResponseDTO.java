package com.clinicapsicologiaapi.dto;

public class SessaoResponseDTO {

    private Long id;
    private Long pacienteId;
    private Long psicologoId;
    private java.time.LocalDateTime dataHora;
    private Integer duracao;
    private String modalidade;
    private String status;
    private Double valor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
    public Long getPsicologoId() { return psicologoId; }
    public void setPsicologoId(Long psicologoId) { this.psicologoId = psicologoId; }
    public java.time.LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(java.time.LocalDateTime dataHora) { this.dataHora = dataHora; }
    public Integer getDuracao() { return duracao; }
    public void setDuracao(Integer duracao) { this.duracao = duracao; }
    public String getModalidade() { return modalidade; }
    public void setModalidade(String modalidade) { this.modalidade = modalidade; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
}
