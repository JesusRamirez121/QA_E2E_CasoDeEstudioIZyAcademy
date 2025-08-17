package com.co.izyacademy.utils.reader;



import com.co.izyacademy.exceptions.ExcelLecturaException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ObtenerCredencialesUtil {
    private ObtenerCredencialesUtil() {
        // Constructor privado para evitar instanciación
    }

    public static Map<String, String> obtenerCredencialesDesdeExcel(String ruta, int fila) throws ExcelLecturaException {
        try {
            Workbook workbook = WorkbookFactory.create(new File(ruta));
            Sheet sheet = workbook.getSheetAt(0); // Asumiendo que las credenciales están en la primera hoja
            Row row = sheet.getRow(fila); // Convertir fila a índice (0-based)

            String usuario = getCellValueAsString(row.getCell(0)); // Asumiendo que el usuario está en la primera columna
            String contrasena = getCellValueAsString(row.getCell(1)); // Asumiendo que la contraseña está en la segunda columna
            workbook.close();

            Map<String, String> credenciales = new HashMap<>();
            credenciales.put("usuario", usuario);
            credenciales.put("contrasena", contrasena);
            return credenciales;

        } catch (IOException e) {
            throw new ExcelLecturaException("Error al abrir el archivo Excel: " + ruta, e);
        } catch (Exception e) {
            throw new ExcelLecturaException("Error al leer las credenciales desde el archivo Excel: ", e);
        }
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
