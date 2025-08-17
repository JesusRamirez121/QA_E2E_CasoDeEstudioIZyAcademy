package com.co.izyacademy.stepsdefinitions;


import com.co.izyacademy.models.Credenciales;
import com.co.izyacademy.tasks.LoginTask;
import com.co.izyacademy.utils.reader.ObtenerCredencialesUtil;
import io.cucumber.java.es.Cuando;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class LoginStepDefinition {

    @Cuando("^el usuario ingresa usuario y contraseña$")
    public void elUsuarioIngresaLasCredenciales() throws Exception{
        String rutaExcel = "src/test/resources/datadriver/credenciales.xlsx";
        int fila = 1; // Cambia esto al número de fila que deseas leer
        // Obtener las credenciales desde el archivo Excel
        Map<String, String> credentials = ObtenerCredencialesUtil.obtenerCredencialesDesdeExcel(rutaExcel, fila);

        theActorInTheSpotlight().attemptsTo(LoginTask.login(Credenciales.builder()
                .usuario(credentials.get("usuario"))
                .contrasena(credentials.get("contrasena"))
                .build()));
    }
}
