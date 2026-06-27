package com.clinicapsicologiaapi.dto;

import jakarta.validation.constraints.*;

public class PacienteRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotNull(message = "data nascimento não pode ser nulo")
    private java.time.LocalDate dataNascimento;
    @NotBlank(message = "encaminhamento não pode estar em branco")
    private String encaminhamento;

    private String observacoes;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public java.time.LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(java.time.LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getEncaminhamento() { return encaminhamento; }
    public void setEncaminhamento(String encaminhamento) { this.encaminhamento = encaminhamento; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
