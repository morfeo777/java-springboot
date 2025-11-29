package com.laboratorio.chad.Service.Menu.Impl;

import com.laboratorio.chad.Dominio.Experimento;
import com.laboratorio.chad.Dominio.ExperimentoFisico;
import com.laboratorio.chad.Dominio.ExperimentoQuimico;
import com.laboratorio.chad.Dominio.Investigador;
import com.laboratorio.chad.Repository.Experimentos.ExperimentoRepository;
import com.laboratorio.chad.Repository.Experimentos.Impl.ExperimentoRepositoryImpl;
import com.laboratorio.chad.Repository.Investigadores.Impl.InvestigadorRepositoryImpl;
import com.laboratorio.chad.Repository.Investigadores.InvestigadorRepository;
import com.laboratorio.chad.Service.Laboratorio.LaboratorioExperimentacionService;
import com.laboratorio.chad.Service.Lector.Impl.LectorLaboratorioChadImpl;
import com.laboratorio.chad.Service.Lector.LectorLaboratorioChad;
import com.laboratorio.chad.Service.Menu.MenuService;

import java.util.List;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService {

    private LaboratorioExperimentacionService laboratorioExperimentacionService;
    private InvestigadorRepository investigadorRepository = new InvestigadorRepositoryImpl();
    private ExperimentoRepository experimentoRepository = new ExperimentoRepositoryImpl();
    private List<Experimento> experimentos;
    private List<ExperimentoQuimico> experimentosQuimicos;
    private List<ExperimentoFisico> experimentosFisicos;
    private List<Investigador> investigadoresList;


    public MenuServiceImpl(LaboratorioExperimentacionService laboratorioExperimentacionService, InvestigadorRepository investigadorRepository, ExperimentoRepository experimentoRepository) {
        this.laboratorioExperimentacionService = laboratorioExperimentacionService;
        this.investigadorRepository = investigadorRepository;
        this.experimentoRepository = experimentoRepository;
    }

    private final LectorLaboratorioChad lectorLaboratorioChad = new LectorLaboratorioChadImpl(investigadorRepository, experimentoRepository);



    @Override
    public void seleccionar(Scanner scanner) {

        int opcion = 0;
        System.out.println("Bienvenidos al Gestor de Experimentos en el Laboratorio Chad");

        do {
            System.out.println("INDIQUE UNA OPCION : ");
            System.out.println("1. REGISTRAR INVESTIGADOR : ");
            System.out.println("2. REGISTRAR UN NUEVO EXPERIMENTO: ");
            System.out.println("3. MOSTRAR LISTADO DE EXPERIMENTOS REALIZADOS: ");
            System.out.println("4. MOSTRAR TOTAL DE EXPERIMENTOS EXITOSOS Y FALLIDOS: ");
            System.out.println("5. MOSTRAR EXPERIMENTO DE MAYOR DURACION: ");
            System.out.println("6. GENERAR REPORTE SIMPLE: ");
            System.out.println("7. MOSTRAR INVESTIGADOR CON MAS EXPERIMENTOS: ");
            System.out.println("8. EXPORTAR A CSV DATOS DE INVESTIGADORES: ");
            System.out.println("9. SALIR ");

            opcion = scanner.nextInt();
            this.ejecutar(opcion, scanner);

        } while (opcion != 9);

    }

    private void ejecutar(int opcion, Scanner scanner) {

        experimentos = experimentoRepository.obtenerExperimentos();
        experimentosQuimicos = experimentoRepository.obtenerExperiQuimico();
        experimentosFisicos = experimentoRepository.obtenerExperiFisico();
        investigadoresList = investigadorRepository.obtenerInvestigadores();

        switch (opcion) {
            case 1:
                System.out.println("\n");
                lectorLaboratorioChad.leerInvestigador(scanner);
                break;
            case 2:
                System.out.println("\n");
                lectorLaboratorioChad.leerExperimento(scanner);
                break;
            case 3:
                System.out.println("\n");
                laboratorioExperimentacionService.mostrarExperimentosRealizados(experimentos);
                break;
            case 4:
                System.out.println("\n");
                laboratorioExperimentacionService.mostrarTotalExperimentosExitososFallidos(experimentos);
                break;
            case 5:
                System.out.println("\n");
                laboratorioExperimentacionService.mostrarExperimentoMayorDuracion(experimentos);
                break;
            case 6:
                System.out.println("\n");
                laboratorioExperimentacionService.reporteSimple(experimentos);
                break;
            case 7:
                System.out.println("\n");
                laboratorioExperimentacionService.mostrarInvestigadorMasExperimentos(experimentosQuimicos, experimentosFisicos, investigadoresList);
                break;
            case 8:
                System.out.println("\n");
                laboratorioExperimentacionService.exportarInvestigadoresCsv(experimentosQuimicos, experimentosFisicos, investigadoresList);
                break;
            case 9:
                System.out.println("\n");
                System.out.println("HASTA LUEGO!");
                System.out.println("\n");
                break;
        }

    }
}
