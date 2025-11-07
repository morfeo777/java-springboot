package com.laboratorio.chad.Dominio;

public class Experimento {

    private String nombre;
    private int duracion;
    private boolean resultado;
    private String tipo_experimento;
    private int id_experimento;

    public Experimento(String nombre, int duracion, boolean resultado, String tipo_experimento, int id_experimento) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.resultado = resultado;
        this.tipo_experimento = tipo_experimento;
        this.id_experimento = id_experimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean getResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public String getTipo_experimento() {
        return tipo_experimento;
    }

    public void setTipo_experimento(String tipo_experimento) {
        this.tipo_experimento = tipo_experimento;
    }

    public int getId_experimento() {
        return id_experimento;
    }

    public void setId_experimento(int id_experimento) {
        this.id_experimento = id_experimento;
    }
}
