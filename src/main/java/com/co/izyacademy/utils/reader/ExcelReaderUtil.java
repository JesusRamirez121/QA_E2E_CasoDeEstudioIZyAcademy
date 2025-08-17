package com.co.izyacademy.utils.reader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExcelReaderUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExcelReaderUtil.class);

    private ExcelReaderUtil() {
        // Constructor privado para evitar instanciación
    }

    public static <T> List<T> leerDatosDesdeExcel(String rutaArchivo, Class<T> claseModelo, String... nombresCampos) {
        List<T> datos = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(rutaArchivo);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Saltar encabezados

                T objeto = crearObjetoDesdeFilaExcel(row, workbook, claseModelo, nombresCampos);
                if (objeto != null) {
                    datos.add(objeto);
                }
            }

        } catch (IOException e) {
            logger.error("Error al leer archivo Excel: {}", e.getMessage());
        }

        logger.info("Datos leídos desde Excel: {}", datos.size());
        return datos;
    }

    private static <T> T crearObjetoDesdeFilaExcel(Row row, Workbook workbook, Class<T> claseModelo, String[] nombresCampos) {
        try {
            T objeto = claseModelo.getDeclaredConstructor().newInstance();

            for (int i = 0; i < nombresCampos.length && i < row.getLastCellNum(); i++) {
                String valorCelda = obtenerValorCelda(row.getCell(i), workbook);
                establecerValorCampo(objeto, nombresCampos[i], valorCelda);
            }

            return objeto;

        } catch (Exception e) {
            logger.error("Error al crear objeto desde fila Excel: {}", e.getMessage());
            return null;
        }
    }

    private static void establecerValorCampo(Object objeto, String nombreCampo, String valor) {
        try {
            String nombreMetodoSet = "set" + nombreCampo.substring(0, 1).toUpperCase() + nombreCampo.substring(1);
            Method metodoSet = objeto.getClass().getMethod(nombreMetodoSet, String.class);
            metodoSet.invoke(objeto, valor);

        } catch (Exception e) {
            logger.warn("No se pudo establecer el valor para el campo: {}", nombreCampo);
        }
    }

    private static String obtenerValorCelda(Cell celda, Workbook workbook) {
        if (celda == null) {
            return "";
        }

        switch (celda.getCellType()) {
            case STRING:
                return celda.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(celda)) {
                    return celda.getDateCellValue().toString();
                }
                double valor = celda.getNumericCellValue();
                return valor == (long) valor ?
                        String.valueOf((long) valor) :
                        String.valueOf(valor);
            case BOOLEAN:
                return String.valueOf(celda.getBooleanCellValue());
            case FORMULA:
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                return obtenerValorCelda(evaluator.evaluateInCell(celda), workbook);
            case BLANK:
                return "";
            case ERROR:
                return "Error en la celda";
            default:
                return "";
        }
    }
}
