package paradigmas.poo.desafio.dominio.CodeChads.Academy;

import java.util.List;

public class Examen {
    private int examenEstudiante;
    private int nota;

    public Examen(int examenEstudiante, int puntaje) {
        this.examenEstudiante = examenEstudiante;
        this.nota = puntaje;
    }

    public int getExamenEstudiante() {
        return examenEstudiante;
    }

    public void setExamenEstudiante(int examenEstudiante) {
        this.examenEstudiante = examenEstudiante;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }


}
