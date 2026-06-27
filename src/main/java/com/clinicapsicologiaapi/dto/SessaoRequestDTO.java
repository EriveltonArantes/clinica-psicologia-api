package com.clinicapsicologiaapi.dto;

import jakarta.validation.constraints.*;

public class SessaoRequestDTO {

    @NotNull(message = "PacienteId é obrigatório")
    @Positive(message = "PacienteId deve ser um ID válido (positivo)")
    private Long pacienteId;
    @NotNull(message = "PsicologoId é obrigatório")
    @Positive(message = "PsicologoId deve ser um ID válido (positivo)")
    private Long psicologoId;
    @FutureOrPresent(message = "data hora não pode ser retroativo")
    @NotNull(message = "data hora não pode ser nulo")
    private java.time.LocalDateTime dataHora;
    @NotNull(message = "duracao não pode ser nulo")
    private Integer duracao;
    @NotBlank(message = "modalidade não pode estar em branco")
    private String modalidade;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private Double valor;

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
