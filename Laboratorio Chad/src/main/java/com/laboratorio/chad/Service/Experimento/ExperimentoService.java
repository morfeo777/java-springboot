package com.laboratorio.chad.Service.Experimento;

import com.laboratorio.chad.Dominio.Experimento;

import java.util.List;

public interface ExperimentoService {

    void experimentosRealizados(List<Experimento> experimentoList);

    int totalExperimentosExitosos(List<Experimento> experimentosList);

    int totalExperimentosFallidos(List<Experimento> experimentosList);

    Experimento experimentoMayorDuracion(List<Experimento> experimentos);

    int promedioDuracionExperimento(List<Experimento> experimentosList);

    int porcentajeExitoGlobalExperimentos(List<Experimento> experimentoList);
}
