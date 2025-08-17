package com.co.izyacademy.utils;

import com.co.izyacademy.userinterface.CrearCategoriaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

public class DificultadSelectionUtil {

    public static void seleccionarDificultad(Actor actor, String dificultad) {
        switch (dificultad.toLowerCase()) {
            case "easy":
                actor.attemptsTo(Click.on(CrearCategoriaPage.CHECKBOX_EASY));
                break;
            case "medium":
                actor.attemptsTo(Click.on(CrearCategoriaPage.CHECKBOX_MEDIUM));
                break;
            case "difficult":
                actor.attemptsTo(Click.on(CrearCategoriaPage.CHECKBOX_DIFFICULT));
                break;
            default:
                throw new IllegalArgumentException("Dificultad no válida: " + dificultad);
        }
    }
}
