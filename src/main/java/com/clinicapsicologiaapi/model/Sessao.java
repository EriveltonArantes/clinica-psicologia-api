package com.clinicapsicologiaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sessaos")
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private Psicologo psicologo;
    private java.time.LocalDateTime dataHora;
    private Integer duracao;
    @Column(nullable = false)
    private String modalidade;
    @Column(nullable = false)
    private String status;
    private Double valor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public Psicologo getPsicologo() { return psicologo; }
    public void setPsicologo(Psicologo psicologo) { this.psicologo = psicologo; }
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
