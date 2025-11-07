package com.laboratorio.chad.Repository.Investigadores.Impl;

import com.laboratorio.chad.Dominio.Investigador;
import com.laboratorio.chad.Repository.Investigadores.InvestigadorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InvestigadorRepositoryImpl implements InvestigadorRepository {

    private List<Investigador> investigadores = new ArrayList<Investigador>();
    Random rand = new Random();

    @Override
    public Investigador registrarInvestigador(Investigador investigador) {
        investigadores.add(investigador);
        return investigador;
    }

    @Override
    public Investigador registrarInvestigador(String nombre, int edad, int id) {
        //int id = rand.nextInt(100);  ---------------- este va donde se carga el investigador
        Investigador investigador = new Investigador(nombre, edad, id);
        return this.registrarInvestigador(investigador);
    }


    @Override
    public List<Investigador> obtenerInvestigadores() {
        return this.getInvestigadores();
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(List<Investigador> investigadores) {
        this.investigadores = investigadores;
    }


}
