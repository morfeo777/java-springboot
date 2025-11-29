package com.laboratorio.chad.Service.Investigador;

import com.laboratorio.chad.Dominio.Experimento;
import com.laboratorio.chad.Dominio.ExperimentoFisico;
import com.laboratorio.chad.Dominio.ExperimentoQuimico;
import com.laboratorio.chad.Dominio.Investigador;

import java.util.List;

public interface InvestigadorService {

    Investigador investigadorMasExperimentos(List<ExperimentoQuimico> experimentoQuimicos, List<ExperimentoFisico> experimentoFisicos, List<Investigador> investigadoresList);

    void exportarInvestigadores(List<ExperimentoQuimico> experimentoQuimicos, List<ExperimentoFisico> experimentoFisicos, List<Investigador> investigadoresList);

}
