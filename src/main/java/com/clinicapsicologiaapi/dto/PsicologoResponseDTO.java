package com.clinicapsicologiaapi.dto;

public class PsicologoResponseDTO {

    private Long id;
    private Long idPacienteId;
    private String nome;
    private String crp;
    private String email;
    private String telefone;
    private String especialidade;
    private Double valorSessao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
