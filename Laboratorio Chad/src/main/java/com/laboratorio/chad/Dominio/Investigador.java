package com.laboratorio.chad.Dominio;

public class Investigador {

    private String nombre;
    private int edad;
    private int id_investigador;
    private int cantidad_experimentos;

    public Investigador(String nombre, int edad, int id_investigador, int cantidad_experimentos) {
        this.nombre = nombre;
        this.edad = edad;
        this.id_investigador = id_investigador;
        this.cantidad_experimentos = cantidad_experimentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId_investigador() {
        return id_investigador;
    }

    public void setId_investigador(int id_investigador) {
        this.id_investigador = id_investigador;
    }

    public int getCantidad_experimentos() {
        return cantidad_experimentos;
    }

    public void setCantidad_experimentos(int cantidad_experimentos) {
        this.cantidad_experimentos = cantidad_experimentos;
    }
}
