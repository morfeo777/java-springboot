package com.laboratorio.chad.Service.Experimento.Impl;

import com.laboratorio.chad.Dominio.Experimento;
import com.laboratorio.chad.Service.Experimento.ExperimentoService;

import java.util.List;

public class ExperimentoServiceImpl implements ExperimentoService {
    @Override
    public void experimentosRealizados(List<Experimento> experimentoList) {
        for (Experimento expi : experimentoList) {
            System.out.printf("| %-22s | %-8d | %5s | %-8s |%n", expi.getNombre(), expi.getDuracion(), expi.getResultado(), expi.getTipo_experimento());
        }

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

        int duracionAcumulada = 0;
        int contadorExperimentos = 0;
        for (Experimento expi : experimentosList) {
            duracionAcumulada += expi.getDuracion();
            contadorExperimentos++;
        }
        return duracionAcumulada / contadorExperimentos;
    }

    @Override
    public int porcentajeExitoGlobalExperimentos(List<Experimento> experimentoList) {
        int porcentajeExito = 0;
        int contadorExperimentos = 0;

        for (Experimento expi : experimentoList) {
            contadorExperimentos++;
            if (expi.getResultado()) {
                porcentajeExito++;
            }
        }
        double porExito = ((double) porcentajeExito / contadorExperimentos) * 100;

        return (int) porExito;
    }
}
