package com.co.izyacademy.utils;

import com.co.izyacademy.utils.reader.ExcelReaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FeatureExamplesGenerator {
    private static final Logger logger = LoggerFactory.getLogger(FeatureExamplesGenerator.class);

    private FeatureExamplesGenerator() {
        // Constructor privado para evitar instanciación
    }

    public static <T> void generarExamples(String rutaFeature, String rutaExcel,
                                           Class<T> claseModelo, String... nombresCampos) {
        try {
            List<T> data = ExcelReaderUtil.leerDatosDesdeExcel(rutaExcel, claseModelo, nombresCampos);

            if (data.isEmpty()) {
                logger.warn("No se encontraron datos en el archivo Excel: {}", rutaExcel);
                return;
            }

            StringBuilder examplesBlock = construirExamplesBlock(data, nombresCampos);
            boolean reemplazado = reemplazarBloqueExamples(rutaFeature, examplesBlock);

            if (!reemplazado) {
                logger.warn("No se encontró el bloque de ejemplos en el archivo feature: {}", rutaFeature);
            } else {
                logger.info("Bloque de ejemplos actualizado correctamente en: {}", rutaFeature);
                reemplazarArchivoOriginal(rutaFeature);
            }
        } catch (Exception e) {
            logger.error("Error al generar ejemplos para el feature: {}", rutaFeature, e);
        }
    }

    private static <T> StringBuilder construirExamplesBlock(List<T> datos, String[] nombresCampos) {
        StringBuilder examplesBlock = new StringBuilder();
        examplesBlock.append(String.format("     Ejemplos:%n"));

        // Construir encabezado dinámicamente
        StringBuilder encabezado = new StringBuilder("     |");
        for (String campo : nombresCampos) {
            encabezado.append(String.format(" %s |", campo));
        }
        encabezado.append("%n");
        examplesBlock.append(String.format(encabezado.toString()));

        // Construir filas de datos
        for (T data : datos) {
            StringBuilder fila = new StringBuilder("     |");
            for (String campo : nombresCampos) {
                String valor = obtenerValorCampo(data, campo);
                fila.append(String.format(" %s |", valor));
            }
            fila.append("%n");
            examplesBlock.append(String.format(fila.toString()));
        }

        return examplesBlock;
    }

    private static <T> String obtenerValorCampo(T objeto, String nombreCampo) {
        try {
            String nombreMetodoGet = "get" + nombreCampo.substring(0, 1).toUpperCase() + nombreCampo.substring(1);
            Method metodoGet = objeto.getClass().getMethod(nombreMetodoGet);
            Object valor = metodoGet.invoke(objeto);
            return valor != null ? valor.toString() : "";
        } catch (Exception e) {
            logger.warn("No se pudo obtener el valor para el campo: {}", nombreCampo);
            return "";
        }
    }

    private static boolean reemplazarBloqueExamples(String rutaFeature, StringBuilder examplesBlock) {
        boolean insideExamplesBlock = false;
        boolean replacedBlock = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaFeature));
             BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFeature + ".tmp"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                boolean escribirLinea = true;

                if (trimmed.startsWith("Ejemplos:")) {
                    if (!replacedBlock) {
                        insideExamplesBlock = true;
                        replacedBlock = true;
                        writer.write(examplesBlock.toString());
                        escribirLinea = false;
                    }
                } else if (insideExamplesBlock) {
                    if (!(trimmed.startsWith("|") || trimmed.startsWith("#") || trimmed.isEmpty())) {
                        insideExamplesBlock = false;
                    } else {
                        escribirLinea = false;
                    }
                }

                if (escribirLinea) {
                    writer.write(line);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            logger.error("Error al procesar el archivo feature", e);
            return false;
        }

        return replacedBlock;
    }

    private static void reemplazarArchivoOriginal(String rutaFeature) {
        File original = new File(rutaFeature);
        File temporal = new File(rutaFeature + ".tmp");
        Path originalPath = original.toPath();
        Path temporalPath = temporal.toPath();

        try {
            Files.delete(originalPath);
            Files.move(temporalPath, originalPath);
            logger.info("Archivo actualizado correctamente: {}", rutaFeature);
        } catch (IOException e) {
            logger.error("No se pudo reemplazar el archivo original: {}", rutaFeature, e);
        }
    }
}
