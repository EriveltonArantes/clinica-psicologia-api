package com.clinicapsicologiaapi.dto;

import jakarta.validation.constraints.*;

public class PsicologoRequestDTO {

    @NotNull(message = "IdPacienteId é obrigatório")
    @Positive(message = "IdPacienteId deve ser um ID válido (positivo)")
    private Long idPacienteId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "crp não pode estar em branco")
    private String crp;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "especialidade não pode estar em branco")
    private String especialidade;
    @DecimalMin(value = "0.0", message = "valor sessao não pode ser negativo")
    @NotNull(message = "valor sessao não pode ser nulo")
    private Double valorSessao;

    public Long getIdPacienteId() { return idPacienteId; }
    public void setIdPacienteId(Long idPacienteId) { this.idPacienteId = idPacienteId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCrp() { return crp; }
    public void setCrp(String crp) { this.crp = crp; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public Double getValorSessao() { return valorSessao; }
    public void setValorSessao(Double valorSessao) { this.valorSessao = valorSessao; }
}
