package paradigmas.poo.desafio.dominio.CodeChads.Academy;

import java.util.List;

public class EvaluarEstudiante {

    private Estudiante estudiante;

    public EvaluarEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void evaluar() {
        List<Examen> examenList = estudiante.calcularPuntajesRestantes();

        String resultadoAprobadas = estudiante.verificarAprobadas();

        String mayorVariacion = estudiante.mayorVariacionNotas();

        String mejoraSusNotas = estudiante.mejoraNota();

        List<Examen> notasOrdenadas = estudiante.ordenarNotas();

        String evaluacionFinal = estudiante.acumularNotas();

        System.out.println(resultadoAprobadas);
        System.out.println(mayorVariacion);
        System.out.println(mejoraSusNotas);
        System.out.println("Notas Ordenadas: ");
        for (Examen orde : notasOrdenadas) {
            System.out.println(orde.getNota());
        }

        System.out.println(evaluacionFinal);

        int promedio = estudiante.promedioEstudiante();
        int desviacion = estudiante.desviacionEntreNotas();
        int peorRendimientoExamen3 = estudiante.peorNotaExamen3();

    }

    public void evaluacionEstudiantes() {
        int promedio = estudiante.promedioEstudiante();
        int desviacion = estudiante.desviacionEntreNotas();
        int peorRendimientoExamen3 = estudiante.peorNotaExamen3();
    }
}
