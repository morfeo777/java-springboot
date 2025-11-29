package com.laboratorio.chad.Utils;

import java.util.List;

public class ImpresoraUtils {

    public static void imprimir(String texto) {
        System.out.println(texto);
    }

    public static void imprimirMensajes(List<String> mensajes) {
        for (String mensaje : mensajes) {
            imprimir(mensaje);
        }
    }
}
