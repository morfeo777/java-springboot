package com.laboratorio.chad.Service.Laboratorio;

import com.laboratorio.chad.Dominio.Experimento;
import com.laboratorio.chad.Dominio.ExperimentoFisico;
import com.laboratorio.chad.Dominio.ExperimentoQuimico;
import com.laboratorio.chad.Dominio.Investigador;

import java.util.List;

public interface LaboratorioExperimentacionService {

    /*void registrarInvestigadores(String nombre, int edad, int id);

    void registrarNuevoExperimento(String nombre, int duracion, boolean resultado, String tipo_experimento, int id_experimento);*/

    void mostrarExperimentosRealizados(List<Experimento> experimentos);

    void mostrarTotalExperimentosExitososFallidos(List<Experimento> experimentos);

    void mostrarExperimentoMayorDuracion(List<Experimento> experimentos);

    void reporteSimple(List<Experimento> experimentos);

    void mostrarInvestigadorMasExperimentos(List<ExperimentoQuimico> experimentoQuimicos, List<ExperimentoFisico> experimentoFisicos, List<Investigador> investigadoresList);

    void exportarInvestigadoresCsv(List<ExperimentoQuimico> experimentoQuimicos, List<ExperimentoFisico> experimentoFisicos, List<Investigador> investigadoresList);






}
