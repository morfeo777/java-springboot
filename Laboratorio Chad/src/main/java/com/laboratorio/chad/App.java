package com.laboratorio.chad;

import com.laboratorio.chad.Repository.Experimentos.ExperimentoRepository;
import com.laboratorio.chad.Repository.Experimentos.Impl.ExperimentoRepositoryImpl;
import com.laboratorio.chad.Repository.Investigadores.Impl.InvestigadorRepositoryImpl;
import com.laboratorio.chad.Repository.Investigadores.InvestigadorRepository;
import com.laboratorio.chad.Service.Laboratorio.Impl.LaboratorioExperimentacionServiceImpl;
import com.laboratorio.chad.Service.Laboratorio.LaboratorioExperimentacionService;
import com.laboratorio.chad.Service.Menu.Impl.MenuServiceImpl;
import com.laboratorio.chad.Service.Menu.MenuService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        LaboratorioExperimentacionService laboratorioExperimentacionService = new LaboratorioExperimentacionServiceImpl();
        InvestigadorRepository investigadorRepository = new InvestigadorRepositoryImpl();
        ExperimentoRepository experimentoRepository = new ExperimentoRepositoryImpl();

        MenuService menuService = new MenuServiceImpl(laboratorioExperimentacionService, investigadorRepository, experimentoRepository);
        menuService.seleccionar(scanner);

        scanner.close();



    }
}
