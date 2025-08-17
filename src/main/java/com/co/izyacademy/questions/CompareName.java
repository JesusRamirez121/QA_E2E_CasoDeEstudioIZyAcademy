package com.co.izyacademy.questions;

import com.co.izyacademy.userinterface.UsuarioComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompareName implements Question<String> {
    public static CompareName compare() {
        return new CompareName();
    }

    @Override
    public String answeredBy(Actor actor){
        actor.attemptsTo(
                WaitUntil.the(UsuarioComponent.BTN_USER, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(UsuarioComponent.BTN_USER));

        return Text.of(UsuarioComponent.COMPARE).answeredBy(actor);
    }
}
