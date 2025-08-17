package com.co.izyacademy.utils;

import com.co.izyacademy.models.CasoDeEstudioIZyAcademyModel;
import com.co.izyacademy.models.RegisterModel;

public class FeatureDataGenerator {
        public static void main(String[] args) {
            // Para RegisterModel
            FeatureExamplesGenerator.generarExamples(
                    "src/test/resources/features/register.feature",
                    "src/test/resources/datadriver/formularioRegistro.xlsx",
                    RegisterModel.class,
                    "name", "username", "country", "city", "idNumber", "phone", "email", "password"
            );

            // Para cualquier otro modelo
            FeatureExamplesGenerator.generarExamples(
                    "src/test/resources/features/caso_de_estudio_izyacademy.feature",
                    "src/test/resources/datadriver/CasoDeEstudio.xlsx",
                    CasoDeEstudioIZyAcademyModel.class,
                    "name", "username", "country", "city", "idNumber", "phone", "email", "password", "nombreCategoria", "descripcion", "dificultad","urlPost"
            );
        }

}
