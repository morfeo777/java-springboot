package com.laboratorio.chad.Dominio;

import java.util.List;

public class ExperimentoQuimico {

    int id_experimento;
    String tipoReactivo;
    Investigador investigador;

    public ExperimentoQuimico(int id_experimento, String tipoReactivo, Investigador investigador) {
        this.id_experimento = id_experimento;
        this.tipoReactivo = tipoReactivo;
        this.investigador = investigador;
    }

    public int getId_experimento() {
        return id_experimento;
    }

    public void setId_experimento(int id_experimento) {
        this.id_experimento = id_experimento;
    }

    public String getTipoReactivo() {
        return tipoReactivo;
    }

    public void setTipoReactivo(String tipoReactivo) {
        this.tipoReactivo = tipoReactivo;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }
}
