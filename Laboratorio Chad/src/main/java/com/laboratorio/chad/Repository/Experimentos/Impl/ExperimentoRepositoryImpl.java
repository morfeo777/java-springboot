package com.laboratorio.chad.Repository.Experimentos.Impl;

import com.laboratorio.chad.Dominio.Experimento;
import com.laboratorio.chad.Dominio.ExperimentoFisico;
import com.laboratorio.chad.Dominio.ExperimentoQuimico;
import com.laboratorio.chad.Dominio.Investigador;
import com.laboratorio.chad.Repository.Experimentos.ExperimentoRepository;

import java.util.ArrayList;
import java.util.List;

public class ExperimentoRepositoryImpl implements ExperimentoRepository {

    private List<Experimento> experimentos = new ArrayList<Experimento>();
    private List<ExperimentoQuimico> experimentoQuimicos = new ArrayList<ExperimentoQuimico>();
    private List<ExperimentoFisico> experimentoFisicos = new ArrayList<ExperimentoFisico>();


    @Override
    public Experimento guardarExperimento(Experimento experimento) {
        experimentos.add(experimento);
        return experimento;
    }

    @Override
    public Experimento guardarExperimento(String nombre, int duracion, boolean resultado, String tipo_experimento, int id_experimento) {
        Experimento experimento = new Experimento(nombre, duracion, resultado, tipo_experimento, id_experimento);
        return this.guardarExperimento(experimento);
    }

    @Override
    public List<Experimento> obtenerExperimentos() {
        return this.getExperimentos();
    }

    @Override
    public ExperimentoQuimico guardarExperiQuimico(ExperimentoQuimico experimentoQuimico) {
        experimentoQuimicos.add(experimentoQuimico);
        return experimentoQuimico;
    }

    @Override
    public ExperimentoQuimico guardarExperiQuimico(int id_experimento, String tipoReactivo, Investigador investigador) {
        ExperimentoQuimico experimentoQuimico = new ExperimentoQuimico(id_experimento, tipoReactivo, investigador);
        return this.guardarExperiQuimico(experimentoQuimico);
    }


    @Override
    public List<ExperimentoQuimico> obtenerExperiQuimico() {
        return this.getExperimentoQuimicos();
    }

    @Override
    public ExperimentoFisico guardarExperiFisico(ExperimentoFisico experimentoFisico) {
        experimentoFisicos.add(experimentoFisico);
        return experimentoFisico;
    }

    @Override
    public ExperimentoFisico guardarExperiFisico(int id_experimento, String instrumentoUtilizado, List<Investigador> investigadores) {
        ExperimentoFisico experimentoFisico = new ExperimentoFisico(id_experimento, instrumentoUtilizado, investigadores);
        return this.guardarExperiFisico(experimentoFisico);
    }



    @Override
    public List<ExperimentoFisico> obtenerExperiFisico() {
        return this.getExperimentoFisicos();
    }

    public List<Experimento> getExperimentos() {
        return experimentos;
    }

    public void setExperimentos(List<Experimento> experimentos) {
        this.experimentos = experimentos;
    }

    public List<ExperimentoQuimico> getExperimentoQuimicos() {
        return experimentoQuimicos;
    }

    public void setExperimentoQuimicos(List<ExperimentoQuimico> experimentoQuimicos) {
        this.experimentoQuimicos = experimentoQuimicos;
    }

    public List<ExperimentoFisico> getExperimentoFisicos() {
        return experimentoFisicos;
    }

    public void setExperimentoFisicos(List<ExperimentoFisico> experimentoFisicos) {
        this.experimentoFisicos = experimentoFisicos;
    }
}
