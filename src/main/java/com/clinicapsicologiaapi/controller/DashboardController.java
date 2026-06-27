package com.clinicapsicologiaapi.controller;

import com.clinicapsicologiaapi.model.Psicologo;
import com.clinicapsicologiaapi.model.Paciente;
import com.clinicapsicologiaapi.model.Sessao;
import com.clinicapsicologiaapi.model.Evolucao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.clinicapsicologiaapi.repository.PsicologoRepository psicologoRepository;

    @Autowired
    private com.clinicapsicologiaapi.repository.PacienteRepository pacienteRepository;

    @Autowired
    private com.clinicapsicologiaapi.repository.SessaoRepository sessaoRepository;

    @Autowired
    private com.clinicapsicologiaapi.repository.EvolucaoRepository evolucaoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalPsicologo", psicologoRepository.count());
        resumo.put("somaValorSessaoPsicologo", psicologoRepository.findAll().stream().filter(e -> e.getValorSessao() != null).mapToDouble(e -> e.getValorSessao()).sum());
        resumo.put("totalPaciente", pacienteRepository.count());
        resumo.put("totalSessao", sessaoRepository.count());
        resumo.put("somaValorSessao", sessaoRepository.findAll().stream().filter(e -> e.getValor() != null).mapToDouble(e -> e.getValor()).sum());
        resumo.put("graficoSessao", sessaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalEvolucao", evolucaoRepository.count());
        return resumo;
    }
}
