package com.laboratorio.chad.Service.Laboratorio.Impl;

import com.laboratorio.chad.Dominio.Experimento;
import com.laboratorio.chad.Dominio.ExperimentoFisico;
import com.laboratorio.chad.Dominio.ExperimentoQuimico;
import com.laboratorio.chad.Dominio.Investigador;
import com.laboratorio.chad.Service.Experimento.ExperimentoService;
import com.laboratorio.chad.Service.Investigador.Impl.InvestigadorServiceImpl;
import com.laboratorio.chad.Service.Investigador.InvestigadorService;
import com.laboratorio.chad.Service.Laboratorio.LaboratorioExperimentacionService;
import com.laboratorio.chad.Service.Experimento.Impl.ExperimentoServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static com.laboratorio.chad.Utils.ImpresoraUtils.imprimir;

public class LaboratorioExperimentacionServiceImpl implements LaboratorioExperimentacionService {

    ExperimentoService experimentoService = new ExperimentoServiceImpl();
    InvestigadorService investigadorService = new InvestigadorServiceImpl();

    @Override
    public void mostrarExperimentosRealizados(List<Experimento> experimentos) {

        if (experimentos == null || experimentos.isEmpty()) {
            experimentos = new ArrayList<>();
        }

        System.out.printf("----------------------------------------------%n");
        System.out.printf(" Listado de Experimentos Realizados           %n");
        System.out.printf("----------------------------------------------%n");
        System.out.printf("| %-22s | %-8s | %9s | %-8s |%n", "Nombre del Experimento", "Duracion", "Resultado", "Tipo de Experimento");
        System.out.printf("----------------------------------------------%n");
        experimentoService.experimentosRealizados(experimentos);
        System.out.printf("----------------------------------------------%n");
    }

    @Override
    public void mostrarTotalExperimentosExitososFallidos(List<Experimento> experimentos) {
        if (experimentos == null || experimentos.isEmpty()) {
            experimentos = new ArrayList<>();
        }
        int expeExitosos = 0;
        int expeFallidos = 0;
        expeExitosos = experimentoService.totalExperimentosExitosos(experimentos);
        expeFallidos = experimentoService.totalExperimentosFallidos(experimentos);
        imprimir("Total Experimentos Exitosos: " + expeExitosos);
        imprimir("Total Experimentos Fallidos: " + expeFallidos);
    }

    @Override
    public void mostrarExperimentoMayorDuracion(List<Experimento> experimentos) {
        if (experimentos == null || experimentos.isEmpty()) {
            experimentos = new ArrayList<>();
        }
        Experimento experimento;
        experimento = experimentoService.experimentoMayorDuracion(experimentos);
        System.out.printf("----------------------------------------------%n");
        System.out.printf(" Experimento Mayor Duracion           %n");
        System.out.printf("----------------------------------------------%n");
        System.out.printf("| %-22s | %-8s | %9s | %-8s |%n", "Nombre del Experimento", "Duracion", "Resultado", "Tipo de Experimento");

        System.out.printf("| %-22s | %-8d | %5s | %-8s |%n", experimento.getNombre(), experimento.getDuracion(), experimento.getResultado(), experimento.getTipo_experimento());
        System.out.printf("----------------------------------------------%n");



    }

    @Override
    public void reporteSimple(List<Experimento> experimentos) {

        if (experimentos == null || experimentos.isEmpty()) {
            experimentos = new ArrayList<>();
        }
        int promedioDuracion = 0;
        int porcentajeExito = 0;
        promedioDuracion = experimentoService.promedioDuracionExperimento(experimentos);
        porcentajeExito = experimentoService.porcentajeExitoGlobalExperimentos(experimentos);
        imprimir("Promedio de duración de los experimentos: " + promedioDuracion);
        imprimir("Porcentaje de éxito global: " + porcentajeExito);

    }

    @Override
    public void mostrarInvestigadorMasExperimentos(List<ExperimentoQuimico> experimentoQuimicos, List<ExperimentoFisico> experimentoFisicos, List<Investigador> investigadoresList) {
        if (experimentoFisicos == null || experimentoFisicos.isEmpty()) {
            experimentoFisicos = new ArrayList<>();
        }
        if (experimentoQuimicos == null || experimentoQuimicos.isEmpty()) {
            experimentoQuimicos = new ArrayList<>();
        }
        if (investigadoresList == null || investigadoresList.isEmpty()) {
            investigadoresList = new ArrayList<>();
        }
        Investigador investigadorMasExpe;
        investigadorMasExpe = investigadorService.investigadorMasExperimentos(experimentoQuimicos, experimentoFisicos, investigadoresList);
        System.out.printf("----------------------------------------------%n");
        System.out.printf(" Investigador con Mas Experimentos           %n");
        System.out.printf("----------------------------------------------%n");
        System.out.printf("| %-22s | %-8s | %9s |%n", "Nombre del Investigador", "Edad", "Cantidad Experimentos");
        System.out.printf("| %-22s | %-8d | %5d |%n", investigadorMasExpe.getNombre(), investigadorMasExpe.getEdad(), investigadorMasExpe.getCantidad_experimentos());
        System.out.printf("----------------------------------------------%n");


    }

    @Override
    public void exportarInvestigadoresCsv(List<ExperimentoQuimico> experimentoQuimicos, List<ExperimentoFisico> experimentoFisicos, List<Investigador> investigadoresList) {
        investigadorService.exportarInvestigadores(experimentoQuimicos, experimentoFisicos, investigadoresList);
    }
}
