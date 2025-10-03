package Desafio;

public class CodeChadsAcademy {
    public static void main(String[] args) {
        int[] notaExamen = new int[5];
        int[] notaEstudiante1 = new int[5];
        int[] notaEstudiante2 = new int[5];
        int[] notaEstudiante3 = new int[5];
        int[] notaEstudiante4 = new int[5];
        int[] promedioEstudiantes = new int[4];
        int[] notasOrdenadasMayorMenor = new int[5];

        int examenesAprobados = 0;                
        int variacion = 0;
        int mayorVariacion = 0;
        int pruebaConsecutiva1 = 0;
        int pruebaConsecutiva2 = 0;
        int totalAcumulado = 0;
        int notasAcumuladas1 = 0;
        int notasAcumuladas2 = 0;
        int notasAcumuladas3 = 0;
        int notasAcumuladas4 = 0;

        String mensajeAprobadas = "";
        String mejoraNota = "";
        String evaluacionFinalPorNivel = "";


        notaExamen[0] = 34;
        notaExamen[1] = 77;
        notaExamen[2] = 73;

        notaEstudiante1[0] = 70;
        notaEstudiante1[1] = 90;
        notaEstudiante1[2] = 40;
        notaEstudiante1[3] = 80;
        notaEstudiante1[4] = 10;

        notaEstudiante2[0] = 70;
        notaEstudiante2[1] = 50;
        notaEstudiante2[2] = 40;
        notaEstudiante2[3] = 100;
        notaEstudiante2[4] = 30;

        notaEstudiante3[0] = 60;
        notaEstudiante3[1] = 50;
        notaEstudiante3[2] = 30;
        notaEstudiante3[3] = 80;
        notaEstudiante3[4] = 90;

        notaEstudiante4[0] = 10;
        notaEstudiante4[1] = 90;
        notaEstudiante4[2] = 50;
        notaEstudiante4[3] = 100;
        notaEstudiante4[4] = 1000;
        
        if (notaExamen[1] < 60) {
            notaExamen[3] = 100;
        } else if (notaExamen[1] > 60) {
            notaExamen[3] = notaExamen[1];
        }

        if ((notaExamen[0] + notaExamen[2]) > 150) {
            notaExamen[4] = 95;
        } else {
            notaExamen[4] = 70;
        }
        
        // Recorro las notas
        for(int i = 0; i < 4; i++) {
            totalAcumulado += notaExamen[i];
            if (notaExamen[i] > 60) {
                examenesAprobados++;
            }
            variacion = (notaExamen[i + 1] - notaExamen[i]) / notaExamen[i] * 100;
            if (variacion > mayorVariacion) {
                mayorVariacion = variacion;
                pruebaConsecutiva1 = notaExamen[i];
                pruebaConsecutiva2 = notaExamen[i+1];
            }
            if (notaExamen[i + 1] > notaExamen[i]) {
                mejoraNota = "¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento 📈";
            }
        }        

        if (examenesAprobados == 0) {
            mensajeAprobadas = "Resultado: No aprobaste ninguna. ¡Sos un clon de frontend";
        }

        if (examenesAprobados >= 5) {
            mensajeAprobadas = "Resultado: Aprobaste todas. ¡Backend Sensei!";
        } else {
            mensajeAprobadas = "Resultado: Algunas aprobadas. Sos un refactor en progreso.";
        }

        System.out.println("Materias Aprobadas: " + mensajeAprobadas);
        System.out.println("Mayor salto fue de " + mayorVariacion + " puntos entre la prueba " + pruebaConsecutiva1 + " y la prueba " + pruebaConsecutiva2);
        System.out.println("Bonus por progreso: " + mejoraNota);

        //Notas ordenadas sin usar sort
        System.out.println("Notas ordenadas: ");
        for(int i = 0; i < notaExamen.length; i++){
            for(int j = i + 1; j < notaExamen.length; j++){
                int temp = 0;
                if (notaExamen[j] > notaExamen[i]) {
                    temp = notaExamen[i];
                    notaExamen[i] = notaExamen[j];
                    notaExamen[j] = temp;
                }                
            }
            System.out.println(notaExamen[i]  + " ");
        }



        if (totalAcumulado < 250) {
            evaluacionFinalPorNivel = "Normie total 😢";
        } else if (totalAcumulado < 350) {
            evaluacionFinalPorNivel = "Soft Chad";
        } else if (totalAcumulado < 450) {
            evaluacionFinalPorNivel = "Chad";
        } else if (totalAcumulado >= 450) {
            evaluacionFinalPorNivel = "Stone Chad definitivo 💪";
        }

        System.out.println("Evaluación final por nivel: " + evaluacionFinalPorNivel);
        
       /* for(int i = 0; i < 4; i++){
            notasAcumuladas1 = 0;
            notasAcumuladas2 = 0;
            notasAcumuladas3 = 0;
            notasAcumuladas4 = 0;
            for(int j = 0; j < notaEstudiante1.length; j++){
                notasAcumuladas1 += notaEstudiante1[j];
                notasAcumuladas2 += notaEstudiante2[i];
                notasAcumuladas3 += notaEstudiante3[i];
                notasAcumuladas4 += notaEstudiante4[i];
            }
        }*/
        for(int i = 0; i < notaEstudiante1.length; i++){
            notasAcumuladas1 += notaEstudiante1[i];            
        }
        promedioEstudiantes[0] = notasAcumuladas1 / 5; 
        notasAcumuladas1 = 0;
        for(int i = 0; i < notaEstudiante2.length; i++){
            notasAcumuladas1 += notaEstudiante2[i];            
        }
        promedioEstudiantes[1] = notasAcumuladas1 / 5; 
        notasAcumuladas1 = 0;
        for(int i = 0; i < notaEstudiante3.length; i++){
            notasAcumuladas1 += notaEstudiante3[i];            
        }
        promedioEstudiantes[2] = notasAcumuladas1 / 5; 
        notasAcumuladas1 = 0;
        for(int i = 0; i < notaEstudiante4.length; i++){
            notasAcumuladas1 += notaEstudiante4[i];            
        }
        promedioEstudiantes[3] = notasAcumuladas1 / 5; 
        notasAcumuladas1 = 0;

        //Faltan dos consignas del ultimo punto

        
           


    }
    
}
