package com.laboratorio.chad.Dominio;

import java.util.List;

public class ExperimentoFisico {

    int id_experimento;
    String instrumentoUtilizado;
    List<Investigador> investigadores;

    public ExperimentoFisico(int id_experimento, String instrumentoUtilizado, List<Investigador> investigadores) {
        this.id_experimento = id_experimento;
        this.instrumentoUtilizado = instrumentoUtilizado;
        this.investigadores = investigadores;
    }

    public int getId_experimento() {
        return id_experimento;
    }

    public void setId_experimento(int id_experimento) {
        this.id_experimento = id_experimento;
    }

    public String getInstrumentoUtilizado() {
        return instrumentoUtilizado;
    }

    public void setInstrumentoUtilizado(String instrumentoUtilizado) {
        this.instrumentoUtilizado = instrumentoUtilizado;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(List<Investigador> investigadores) {
        this.investigadores = investigadores;
    }
}
