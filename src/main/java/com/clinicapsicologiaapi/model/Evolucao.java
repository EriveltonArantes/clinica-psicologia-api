package com.clinicapsicologiaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evolucoes")
public class Evolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "psicologo_id")
    private Psicologo psicologo;
    @ManyToOne
    @JoinColumn(name = "dataSessao_id")
    private Sessao dataSessao;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String humor;
    @Column(nullable = false)
    private String progresso;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public Psicologo getPsicologo() { return psicologo; }
    public void setPsicologo(Psicologo psicologo) { this.psicologo = psicologo; }
    public Sessao getDataSessao() { return dataSessao; }
    public void setDataSessao(Sessao dataSessao) { this.dataSessao = dataSessao; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getHumor() { return humor; }
    public void setHumor(String humor) { this.humor = humor; }
    public String getProgresso() { return progresso; }
    public void setProgresso(String progresso) { this.progresso = progresso; }
}
