package com.co.izyacademy.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DescripcionCategoriaQuestion implements Question<String> {

    private static final Logger logger = LoggerFactory.getLogger(DescripcionCategoriaQuestion.class);

    public static DescripcionCategoriaQuestion obtenerDescripcion() {
        return new DescripcionCategoriaQuestion();
    }

    @Override
    public String answeredBy(Actor actor) {
        String descripcionActual = Serenity.sessionVariableCalled("descripcionDetallada");
        logger.info("========================================");
        logger.info("Descripción actual: {}", descripcionActual);
        logger.info("========================================");
        return descripcionActual;
    }
}
