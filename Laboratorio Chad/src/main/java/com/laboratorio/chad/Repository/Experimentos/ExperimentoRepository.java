package com.laboratorio.chad.Repository.Experimentos;

import com.laboratorio.chad.Dominio.Experimento;
import com.laboratorio.chad.Dominio.ExperimentoFisico;
import com.laboratorio.chad.Dominio.ExperimentoQuimico;
import com.laboratorio.chad.Dominio.Investigador;

import java.util.List;

public interface ExperimentoRepository {

    Experimento guardarExperimento(Experimento experimento);

    Experimento guardarExperimento(String nombre, int duracion, boolean resultado, String tipo_experimento, int id_experimento);

    List<Experimento> obtenerExperimentos();

    ExperimentoQuimico guardarExperiQuimico(int id_experimento , String tipoReactivo, Investigador investigador);

    ExperimentoQuimico guardarExperiQuimico(ExperimentoQuimico experimentoQuimico);

    List<ExperimentoQuimico> obtenerExperiQuimico();

    ExperimentoFisico guardarExperiFisico(int id_experimento, String instrumentoUtilizado, List<Investigador> investigadores);

    ExperimentoFisico guardarExperiFisico(ExperimentoFisico experimentoFisico);

    List<ExperimentoFisico> obtenerExperiFisico();

}
