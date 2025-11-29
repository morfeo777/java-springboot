package com.laboratorio.chad.Service.Lector.Impl;

import com.laboratorio.chad.Dominio.Experimento;
import com.laboratorio.chad.Dominio.Investigador;
import com.laboratorio.chad.Repository.Experimentos.ExperimentoRepository;
import com.laboratorio.chad.Repository.Investigadores.InvestigadorRepository;
import com.laboratorio.chad.Service.Lector.LectorLaboratorioChad;
import com.laboratorio.chad.Utils.LectorUtils;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LectorLaboratorioChadImpl implements LectorLaboratorioChad {

    private InvestigadorRepository investigadorRepository;
    private ExperimentoRepository experimentoRepository;

    public LectorLaboratorioChadImpl(InvestigadorRepository investigadorRepository, ExperimentoRepository experimentoRepository) {
        this.investigadorRepository = investigadorRepository;
        this.experimentoRepository = experimentoRepository;
    }

    @Override
    public void leerInvestigador(Scanner scanner) {
        // esta clase tiene que devolver un investigador
        Random rand = new Random();
        int id = rand.nextInt(100);

        System.out.println("Ingrese un Nuevo Investigador: ");

        String nombre = LectorUtils.nombreInvestigador(scanner);
        int edad = LectorUtils.edadInvestigador(scanner);

        this.investigadorRepository.registrarInvestigador(nombre, edad, id);

    }

    @Override
    public void leerExperimento(Scanner scanner) {
        //esta clase tiene que devolver un experimento
        Random rand = new Random();
        int idExperimento = rand.nextInt(100);

        System.out.println("Ingrese un Nuevo Experimento: ");


        String tipoExperimento = LectorUtils.tipoExperimento(scanner);

        if (tipoExperimento.equals("quimico")) {
            System.out.println("Ingrese Nuevo Experimento Quimico");
            String tipoReactivo = LectorUtils.tipoReactivo(scanner);
            Investigador investigadorQuimico = LectorUtils.investigadorQuimico(scanner);

            this.experimentoRepository.guardarExperiQuimico(idExperimento, tipoReactivo, investigadorQuimico);
        } else if (tipoExperimento.equals("fisico")) {
            System.out.println("Ingrese Nuevo Experimento Fisico");
            String instrumentoUtilizado = LectorUtils.instrumentoUtilizado(scanner);
            int cantidadInvestigadores = LectorUtils.cantidadInvestigadoresFisicos(scanner);
            System.out.println("Ingreso de Investigadores para Experimento Fisico");
            List<Investigador> investigadoresList = LectorUtils.investigadoresExpFisico(cantidadInvestigadores, scanner);

            this.experimentoRepository.guardarExperiFisico(idExperimento, instrumentoUtilizado, investigadoresList);

        }

        String nombre = LectorUtils.nombreExperimento(scanner);
        int duracionExperimento = LectorUtils.duracionExperimento(scanner);
        boolean resultadoExperimento = LectorUtils.resultadoExperimento(scanner);

        this.experimentoRepository.guardarExperimento(nombre, duracionExperimento, resultadoExperimento, tipoExperimento, idExperimento);

    }
}
