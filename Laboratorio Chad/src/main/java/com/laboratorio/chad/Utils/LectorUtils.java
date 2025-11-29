package com.laboratorio.chad.Utils;

import com.laboratorio.chad.Dominio.Investigador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LectorUtils {

    public static String nombreInvestigador(Scanner scanner) {
        System.out.println("Ingrese Nombre del Investigador");
        String nombre = scanner.nextLine();
        return nombre;
    }

    public static int edadInvestigador(Scanner scanner) {

        int edad = -1;

        while (edad < 0) {
            System.out.println("Ingrese Edad del Investigador");
            edad = scanner.nextInt();

            if (edad < 0) {
                System.out.println("Ingrese un numero positivo");
                //edad = LectorUtils.edadInvestigador(scanner);
            }

        }

        return edad;
    }

    public static String nombreExperimento(Scanner scanner) {
        System.out.println("Ingrese Nombre del Experimento");
        String nombreExperimento = scanner.nextLine();
        return nombreExperimento;
    }

    public static int duracionExperimento(Scanner scanner) {
        System.out.println("Ingrese Duracion del Experimento");
        int duracion = scanner.nextInt();
        return duracion;
    }

    public static boolean resultadoExperimento(Scanner scanner) {

        int valor = -1;
        boolean resultExperiFinal = false;

        while (valor < 0) {

            System.out.println("Ingrese Resultado del Experimento(E = exito, F = fallo)");
            String resultado = scanner.nextLine();
            if (resultado.equals("E")) {
                valor = 1;
                resultExperiFinal = true;
            } else if (resultado.equals("F")) {
                valor = 1;
                resultExperiFinal = false;
            } else {
                System.out.println("Ingrese solamente la letra E o F");
            }

        }
        return resultExperiFinal;

    }

    public static String tipoExperimento(Scanner scanner) {

        int valor = -1;
        String tipoExperiFinal = "";


        while (valor < 0) {

            System.out.println("Ingrese Tipo de Experimento( Q = quimico, F = fisico )");
            String tipoExperimento = scanner.nextLine();

            if (tipoExperimento.equals("Q")) {
                valor = 1;
                tipoExperiFinal = "quimico";
            } else if (tipoExperimento.equals("F")) {
                valor = 1;
                tipoExperiFinal = "fisico";
            } else {
                System.out.println("Ingrese solamente la letra Q o F");
            }
        }


        return tipoExperiFinal;
    }

    public static String tipoReactivo(Scanner scanner) {

        System.out.println("Ingrese Tipo de Reactivo del Experimento Quimico");
        return scanner.nextLine();
    }

    public static Investigador investigadorQuimico(Scanner scanner) {
        Random rand = new Random();
        int id = rand.nextInt(100);
        int cantidadExperimentos = 0;
        System.out.println("Ingrese el Investigador para el Experimento Quimico: ");

        String nombre = nombreInvestigador(scanner);
        int edad = edadInvestigador(scanner);

        return new Investigador(nombre, edad, id, cantidadExperimentos);

    }

    public static String instrumentoUtilizado(Scanner scanner) {

        System.out.println("Ingrese Instrumento Utilizado en el Experimento Fisico");
        return scanner.nextLine();
    }

    public static int cantidadInvestigadoresFisicos(Scanner scanner) {
        System.out.println("Ingrese cantidad de Investigadores para el Experimento Fisico");
        return scanner.nextInt();
    }

    public static List<Investigador> investigadoresExpFisico(int cantidadInvesti, Scanner scanner) {

        Random rand = new Random();
        int id = rand.nextInt(100);
        int cantidadExperimentos = 0;
        List<Investigador> investigadoresList = new ArrayList<>();

        System.out.println("Ingrese " + cantidadInvesti + " Investigadores para el Experimento Fisico");
        for (int i = 0; i < cantidadInvesti; i++) {
            String nombre = nombreInvestigador(scanner);
            int edad = edadInvestigador(scanner);
            Investigador investigadorFisico = new Investigador(nombre, edad, id, cantidadExperimentos);
            investigadoresList.add(investigadorFisico);
        }

        return investigadoresList;


    }

}
