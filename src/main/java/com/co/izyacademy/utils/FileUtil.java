package com.co.izyacademy.utils;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    public static String getResourceFilePath(String fileName) {
        URL resource = FileUtil.class.getClassLoader().getResource("files/" + fileName);
        if (resource == null) {
            throw new RuntimeException("Archivo no encontrado: " + fileName);
        }
        try {
            return Paths.get(resource.toURI()).toAbsolutePath().toString();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la ruta del archivo: " + fileName, e);
        }
    }

    public static Path getResourceFileAsPath(String fileName) {
        URL resource = FileUtil.class.getClassLoader().getResource("files/" + fileName);
        if (resource == null) {
            throw new RuntimeException("Archivo no encontrado: " + fileName);
        }
        try {
            return Paths.get(resource.toURI());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el Path del archivo: " + fileName, e);
        }
    }
}