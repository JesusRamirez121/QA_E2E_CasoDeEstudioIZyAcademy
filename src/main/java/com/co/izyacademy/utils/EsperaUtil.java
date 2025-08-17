package com.co.izyacademy.utils;

import com.co.izyacademy.exceptions.EsperaProcessingException;

public class EsperaUtil {
    private EsperaUtil() {
        // Constructor privado para evitar instanciación
    }

    public static void esperar(long milisegundos, String mensajeError) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new EsperaProcessingException(mensajeError, e);
        }
    }

    public static void esperar(long milisegundos) {
        esperar(milisegundos, "Error durante la espera");
    }
}
