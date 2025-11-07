package com.laboratorio.chad.Repository.Investigadores;

import com.laboratorio.chad.Dominio.Investigador;

import java.util.List;

public interface InvestigadorRepository {

    Investigador registrarInvestigador(String nombre, int edad, int id);

    Investigador registrarInvestigador(Investigador investigador);

    List<Investigador> obtenerInvestigadores();

}
