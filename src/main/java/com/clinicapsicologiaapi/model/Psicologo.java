package com.clinicapsicologiaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "psicologos")
public class Psicologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPaciente_id")
    private Paciente idPaciente;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String crp;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String especialidade;
    private Double valorSessao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Paciente getIdPaciente() { return idPaciente; }
    public void setIdPaciente(Paciente idPaciente) { this.idPaciente = idPaciente; }
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
