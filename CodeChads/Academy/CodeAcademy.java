package paradigmas.poo.desafio.dominio.CodeChads.Academy;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;

public class CodeAcademy {
    public static void main(String[] args) {
        System.out.println("CodeChads Academy");
        List<Examen> examenesEstudianteOriginal = new ArrayList<Examen>();

        examenesEstudianteOriginal.add(new Examen(1, 70));
        examenesEstudianteOriginal.add(new Examen(2, 80));
        examenesEstudianteOriginal.add(new Examen(3, 100));

        Estudiante estudianteOriginal = new Estudiante(examenesEstudianteOriginal);

        EvaluarEstudiante evaluarEstudiante = new EvaluarEstudiante(estudianteOriginal);
        evaluarEstudiante.evaluar();

        List<Examen> examenesEstudiante1 = new ArrayList<Examen>();
        List<Examen> peorNotaExamen3 = new ArrayList<Examen>();


        examenesEstudiante1.add(new Examen(1, 50));
        examenesEstudiante1.add(new Examen(2, 80));
        examenesEstudiante1.add(new Examen(3, 20));

        Estudiante estudiante1 = new Estudiante(examenesEstudiante1);

        int promedioEstudiante1 = estudiante1.promedioEstudiante();
        int desviacionEstudiante1 = estudiante1.desviacionEntreNotas();
        peorNotaExamen3.add(new Examen(0, examenesEstudiante1.get(2).getNota()));

        List<Examen> examenesEstudiante2 = new ArrayList<Examen>();

        examenesEstudiante2.add(new Examen(1, 100));
        examenesEstudiante2.add(new Examen(2, 70));
        examenesEstudiante2.add(new Examen(3, 90));

        Estudiante estudiante2 = new Estudiante(examenesEstudiante2);

        int promedioEstudiante2 = estudiante2.promedioEstudiante();
        int desviacionEstudiante2 = estudiante2.desviacionEntreNotas();
        peorNotaExamen3.add(new Examen(1, examenesEstudiante2.get(2).getNota()));


        List<Examen> examenesEstudiante3 = new ArrayList<Examen>();

        examenesEstudiante3.add(new Examen(1, 30));
        examenesEstudiante3.add(new Examen(2, 70));
        examenesEstudiante3.add(new Examen(3, 100));

        Estudiante estudiante3 = new Estudiante(examenesEstudiante3);

        int promedioEstudiante3 = estudiante3.promedioEstudiante();
        int desviacionEstudiante3 = estudiante3.desviacionEntreNotas();
        peorNotaExamen3.add(new Examen(2, examenesEstudiante3.get(2).getNota()));

        List<Examen> examenesEstudiante4 = new ArrayList<Examen>();

        examenesEstudiante4.add(new Examen(1, 90));
        examenesEstudiante4.add(new Examen(2, 50));
        examenesEstudiante4.add(new Examen(3, 40));

        Estudiante estudiante4 = new Estudiante(examenesEstudiante4);

        int promedioEstudiante4 = estudiante4.promedioEstudiante();
        int desviacionEstudiante4 = estudiante4.desviacionEntreNotas();
        peorNotaExamen3.add(new Examen(3, examenesEstudiante4.get(2).getNota()));

        int promedioMasAlto = promedioEstudiante1;
        int estudiantePromedioMasAlto = 1;

        if (promedioEstudiante2 > promedioMasAlto) {
            promedioMasAlto = promedioEstudiante2;
            estudiantePromedioMasAlto = 2;
        } else if (promedioEstudiante3 > promedioMasAlto) {
            promedioMasAlto = promedioEstudiante3;
            estudiantePromedioMasAlto = 3;
        } else if (promedioEstudiante4 > promedioMasAlto) {
            promedioMasAlto = promedioEstudiante4;
            estudiantePromedioMasAlto = 4;
        }

        int desviacionEntreNotas = desviacionEstudiante1;
        int estudianteConMenorDesviacion = 1;

        if (desviacionEstudiante2 < desviacionEntreNotas) {
            desviacionEntreNotas = desviacionEstudiante2;
            estudianteConMenorDesviacion = 2;
        } else if (desviacionEstudiante3 < desviacionEntreNotas) {
            desviacionEntreNotas = desviacionEstudiante3;
            estudianteConMenorDesviacion = 3;
        } else if (desviacionEstudiante4 < desviacionEntreNotas) {
            desviacionEntreNotas = desviacionEstudiante4;
            estudianteConMenorDesviacion = 4;
        }

        Examen peorNota3 = peorNotaExamen3.getFirst();

        for (Examen peorExamNota3 : peorNotaExamen3) {
            if (peorExamNota3.getNota() < peorNota3.getNota()) {
                peorNota3 = peorExamNota3;
            }
        }



        System.out.println("El estudiante con mayor promedio es: " + estudiantePromedioMasAlto + " con un promedio de: " + promedioMasAlto);
        System.out.println("El estudiante mas regular fue: " + estudianteConMenorDesviacion + " con una desviacion de: " + desviacionEntreNotas);
        System.out.println("El Peor Rendimiento en el examen 3 fue el estudiante: " + peorNota3.getExamenEstudiante() + " con una Nota de: " + peorNota3.getNota());








    }
}
