package com.laboratorio.chad.Service.Experimento.Impl;

import com.laboratorio.chad.Dominio.Experimento;
import com.laboratorio.chad.Service.Experimento.ExperimentoService;

import java.util.List;

public class ExperimentoServiceImpl implements ExperimentoService {
    @Override
    public List<Experimento> experimentosRealizados(List<Experimento> experimentoList) {
        return List.of();
    }

    @Override
    public int totalExperimentosExitosos(List<Experimento> experimentosList) {
        int exitosos = 0;
        for (Experimento exp : experimentosList) {
            if (exp.getResultado()) {
                exitosos++;
            }
        }
        return exitosos;
    }

    @Override
    public int totalExperimentosFallidos(List<Experimento> experimentosList) {
        int fallidos = 0;
        for (Experimento expi : experimentosList) {
            if (!expi.getResultado()) {
                fallidos++;
            }
        }
        return fallidos;
    }

    @Override
    public Experimento experimentoMayorDuracion(List<Experimento> experimentos) {
        int mayorDuracion = experimentos.getFirst().getDuracion();
        Experimento experimentoMayorDuracion = experimentos.getFirst();

        for (Experimento expi : experimentos) {
            if (expi.getDuracion() > mayorDuracion) {
                mayorDuracion = expi.getDuracion();
                experimentoMayorDuracion = expi;
            }
        }
        return experimentoMayorDuracion;
    }

    @Override
    public int promedioDuracionExperimento(List<Experimento> experimentosList) {

        return 0;
    }

    @Override
    public int porcentajeExitoGlobalExperimentos(List<Experimento> experimentoList) {
        return 0;
    }
}
