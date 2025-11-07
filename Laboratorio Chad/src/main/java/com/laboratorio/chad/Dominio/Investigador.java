package com.laboratorio.chad.Dominio;

public class Investigador {

    private String nombre;
    private int edad;
    private int id_investigador;

    public Investigador(String nombre, int edad, int id_investigador) {
        this.nombre = nombre;
        this.edad = edad;
        this.id_investigador = id_investigador;
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
}
