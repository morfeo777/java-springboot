package paradigmas.poo.desafio.dominio.CodeChads.Academy;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private List<Examen> examenes;

    public Estudiante(List<Examen> examenes) {
        this.examenes = examenes;
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public List<Examen> calcularPuntajesRestantes() {

        Examen notaSegunda = examenes.get(1);
        int notaAuxiliar = notaSegunda.getNota();

        if (notaSegunda.getNota() < 60) {
            examenes.add(new Examen(3, 100));
        } else if (notaSegunda.getNota() > 60) {
            examenes.add(new Examen(3, notaAuxiliar));
        }

        Examen notaPrimera = examenes.get(0);
        Examen notaTercera = examenes.get(2);
        int sumaDeNotas = notaPrimera.getNota() + notaTercera.getNota();
        if (sumaDeNotas > 150) {
            examenes.add(new Examen(4, 95));
        } else {
            examenes.add(new Examen(4, 70));
        }
        return examenes;

    }

    public String verificarAprobadas() {

        //2da Parte - 1. Verificar si aprobó todas:

        int contadorAprobadas = 0;

        for (Examen examen : examenes) {
            if (examen.getNota() >= 60) {
                contadorAprobadas++;
            }
        }
        String resultado = "";
        if (contadorAprobadas == 5) {
            resultado = "Resultado: Aprobaste todas. ¡Backend Sensei!";
        } else if (contadorAprobadas == 0) {
            resultado = "Resultado: No aprobaste ninguna. ¡Sos un clon de frontend!";
        } else {
            resultado = "Resultado: Algunas aprobadas. Sos un refactor en progreso.";
        }
        return resultado;

    }

    public String mayorVariacionNotas() {

        //2. Prueba más inconsistente

        int variacion = 0;
        int mayorVariacion = 0;
        int notaAuxiliarPrimera = 0;
        int notaAuxiliarSegunda = 0;
        Examen notaVariacionPrimera;
        Examen notaVariacionSegunda;
        int notaPrimera = 0;
        int notaSegunda = 0;

        for(int i = 0; i < 4; i++) {

            notaVariacionPrimera = examenes.get(i);
            notaVariacionSegunda = examenes.get(i+1);
            notaAuxiliarPrimera = notaVariacionPrimera.getNota();
            notaAuxiliarSegunda = notaVariacionSegunda.getNota();
            variacion = (notaAuxiliarSegunda - notaAuxiliarPrimera) / notaAuxiliarPrimera * 100;

            if (variacion > mayorVariacion) {
                mayorVariacion = variacion;
                notaPrimera = i;
                notaSegunda = i + 1;
            }
        }
        return "Mayor salto fue de " + mayorVariacion + " puntos entre la prueba " + notaPrimera + " y la prueba " + notaSegunda;

    }

    public String mejoraNota() {

        //3. Bonus por progreso:

        Examen notaPrimera;
        Examen notaSegunda;
        int notaAuxiliarPrimera = 0;
        int notaAuxiliarSegunda = 0;
        String resultadoMejora = "NONE";

        for(int i = 0; i < 4; i++) {
            notaPrimera = examenes.get(i);
            notaSegunda = examenes.get(i + 1);
            notaAuxiliarPrimera = notaPrimera.getNota();
            notaAuxiliarSegunda = notaSegunda.getNota();

            if (notaAuxiliarSegunda > notaAuxiliarPrimera) {
                resultadoMejora = "¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento 📈";
            }
        }
        return resultadoMejora;
    }


    public List<Examen> ordenarNotas() {

        //4. Mostrar notas ordenadas (sin usar sort)

        List<Examen> examenListAuxiliar = new ArrayList<>(examenes);

        int[] notaExamen = new int[examenes.size()];
        for (int i = 0; i < notaExamen.length; i++) {
            for (Examen ex: examenes) {
                notaExamen[i] = ex.getNota();
            }
        }

        for(int i = 0; i < notaExamen.length; i++){
            for(int j = i + 1; j < notaExamen.length; j++){
                int temp = 0;
                if (notaExamen[j] > notaExamen[i]) {
                    temp = notaExamen[i];
                    notaExamen[i] = notaExamen[j];
                    notaExamen[j] = temp;
                }
            }
        }
        for (int i = 0; i < notaExamen.length; i++) {
            examenListAuxiliar.get(i).setNota(notaExamen[i]);
        }
        return examenListAuxiliar;

    }

    public String acumularNotas() {

        //5. Evaluación final por nivel

        Examen examenMayorNota = examenes.getFirst();
        for (Examen exo : examenes) {
            if (exo.getNota() > examenMayorNota.getNota()) {
                examenMayorNota = exo;
            }
        }

        int totalAcumulado = examenMayorNota.getNota();
        String evaluacionFinalPorNivel = "";

        if (totalAcumulado < 250) {
            evaluacionFinalPorNivel = "Normie total 😢";
        } else if (totalAcumulado < 350) {
            evaluacionFinalPorNivel = "Soft Chad";
        } else if (totalAcumulado < 450) {
            evaluacionFinalPorNivel = "Chad";
        } else if (totalAcumulado >= 450) {
            evaluacionFinalPorNivel = "Stone Chad definitivo 💪";
        }

        return evaluacionFinalPorNivel;
    }

    public int promedioEstudiante() {

        int notaAcumulada = 0;
        int promedio = 0;

        for (Examen exu : examenes) {
            notaAcumulada+= exu.getNota();
        }

        promedio = notaAcumulada / 5;

        return promedio;

    }

    public int desviacionEntreNotas() {
        int primerNota = 0;
        int segundaNota = 0;
        int contadorDesviaciones = 0;
        for (int i = 0; i < examenes.size(); i++) {
            primerNota = examenes.get(i).getNota();
            segundaNota = examenes.get(i + 1).getNota();

            if (primerNota != segundaNota) {
                contadorDesviaciones++;
            }
        }

        return contadorDesviaciones;
    }

    public int peorNotaExamen3() {
        Examen peorNota = examenes.getFirst();
        for (Examen ex : examenes) {
            if (ex.getNota() < peorNota.getNota()) {
                peorNota = ex;
            }
        }

        return peorNota.getNota();
    }



}
