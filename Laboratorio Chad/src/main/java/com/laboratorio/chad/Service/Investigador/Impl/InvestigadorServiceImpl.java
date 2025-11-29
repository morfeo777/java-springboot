package com.laboratorio.chad.Service.Investigador.Impl;

import com.laboratorio.chad.Dominio.ExperimentoFisico;
import com.laboratorio.chad.Dominio.ExperimentoQuimico;
import com.laboratorio.chad.Dominio.Investigador;
import com.laboratorio.chad.Service.Investigador.InvestigadorService;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static com.laboratorio.chad.Utils.ImpresoraUtils.imprimir;

public class InvestigadorServiceImpl implements InvestigadorService {

    private final String UBICACION_ARCHIVO = "\\src\\main\\java\\com\\laboratorio\\chad\\Resource";

    CSVWriter csvWriter;

    @Override
    public Investigador investigadorMasExperimentos(List<ExperimentoQuimico> experimentoQuimicos, List<ExperimentoFisico> experimentoFisicos, List<Investigador> investigadoresList) {

        List<Investigador> totalInvestiExperFisicos;
        List<Investigador> totalInvestiExperQuimico;
        Investigador investigadorMasExperimentosQuimico;
        Investigador investigadorMasExperimentosFisico;
        Investigador investigadorMasExperimentos;


        totalInvestiExperQuimico = this.experiQuimicoInvestigador(experimentoQuimicos, investigadoresList);
        totalInvestiExperFisicos = this.experiFisicoInvestigador(experimentoFisicos, investigadoresList);

        investigadorMasExperimentosQuimico = totalInvestiExperQuimico.getFirst();
        for (Investigador investQ : totalInvestiExperQuimico) {
            if (investQ.getCantidad_experimentos() > investigadorMasExperimentosQuimico.getCantidad_experimentos()) {
                investigadorMasExperimentosQuimico = investQ;
            }
        }

        investigadorMasExperimentosFisico = totalInvestiExperFisicos.getFirst();
        for (Investigador investF : totalInvestiExperFisicos) {
            if (investF.getCantidad_experimentos() > investigadorMasExperimentosFisico.getCantidad_experimentos()) {
                investigadorMasExperimentosFisico = investF;
            }
        }

        if (investigadorMasExperimentosQuimico.getCantidad_experimentos() > investigadorMasExperimentosFisico.getCantidad_experimentos()) {
            investigadorMasExperimentos = investigadorMasExperimentosQuimico;
        } else {
            investigadorMasExperimentos = investigadorMasExperimentosFisico;
        }

        return investigadorMasExperimentos;
    }

    @Override
    public void exportarInvestigadores(List<ExperimentoQuimico> experimentoQuimicos, List<ExperimentoFisico> experimentoFisicos, List<Investigador> investigadoresList) {

        List<Investigador> investigadores;
        investigadores = this.cargarExperimentosInvestigadores(experimentoQuimicos, experimentoFisicos, investigadoresList);

        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("total_investigadores.csv");

        try {
            this.csvWriter = new CSVWriter(new FileWriter(ruta));
            String[] encabezado = {"NOMBRE", "EDAD", "CANTIDAD DE EXPERIMENTOS"};
            this.csvWriter.writeNext(encabezado);

            for (Investigador investi : investigadores) {
                String[] datos = {investi.getNombre(), Integer.toString(investi.getEdad()), Integer.toString(investi.getCantidad_experimentos())};
                this.csvWriter.writeNext(datos);
            }

            imprimir("Investigadores Exportados al CSV");
            this.cerrarWriter();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Investigador> experiQuimicoInvestigador(List<ExperimentoQuimico> experimentosQuimicos, List<Investigador> investigadoresList){
        int cantidadExperimentos = 0;
        for (Investigador inves : investigadoresList) {

            for (ExperimentoQuimico expi : experimentosQuimicos) {

                if (inves.getId_investigador() == expi.getInvestigador().getId_investigador()) {
                    cantidadExperimentos++;
                }
            }
            inves.setCantidad_experimentos(cantidadExperimentos);
        }

        return investigadoresList;
    }

    public List<Investigador> experiFisicoInvestigador(List<ExperimentoFisico> experimentosFisicos, List<Investigador> investigadoresList) {
        int cantidadExperimentos = 0;
        List<Investigador> investiFisico = new ArrayList<>();

        for (ExperimentoFisico experimenFisico : experimentosFisicos) {
            investiFisico.addAll(experimenFisico.getInvestigadores());
            //investiFisico.add((Investigador) experimenFisico.getInvestigadores());
        }


        for (Investigador inves : investigadoresList) {
            for (Investigador investigador : investiFisico) {
                if (inves.getId_investigador() == investigador.getId_investigador()) {
                    cantidadExperimentos++;
                }
            }
            inves.setCantidad_experimentos(cantidadExperimentos);
        }
        return investigadoresList;
    }

    public List<Investigador> cargarExperimentosInvestigadores(List<ExperimentoQuimico> experimentoQuimicos, List<ExperimentoFisico> experimentoFisicos, List<Investigador> investigadoresList) {

        List<Investigador> totalInvestiExperFisicos;
        List<Investigador> totalInvestiExperQuimico;
        List<Investigador> totalExperimentos = new ArrayList<>();

        totalInvestiExperQuimico = this.experiQuimicoInvestigador(experimentoQuimicos, investigadoresList);
        totalInvestiExperFisicos = this.experiFisicoInvestigador(experimentoFisicos, investigadoresList);

        totalExperimentos.addAll(totalInvestiExperQuimico);
        totalExperimentos.addAll(totalInvestiExperFisicos);


        return totalExperimentos;
    }

    private void cerrarWriter(){
        if ( this.csvWriter != null ){
            try {
                this.csvWriter.close();
            }catch (IOException e) {
                System.out.println("Algo salio mal motivo : " + e.getMessage());
            }
        }
    }
}
