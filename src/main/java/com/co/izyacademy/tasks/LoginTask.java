package com.co.izyacademy.tasks;

import com.co.izyacademy.models.Credenciales;
import com.co.izyacademy.userinterface.LoginPage;
import com.co.izyacademy.userinterface.MenuHamburgerComponent;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {
    private final Credenciales credentials;

    public LoginTask(Credenciales credentials) {
        this.credentials = credentials;
    }

    public static Performable login(Credenciales credencials) {
        return instrumented(LoginTask.class, credencials);
    }


    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                MoveMouse.to(MenuHamburgerComponent.TOOGLE_MENU_HAMBURGER),
                Click.on(MenuHamburgerComponent.TOOGLE_MENU_HAMBURGER),
                MoveMouse.to(MenuHamburgerComponent.LOGIN_BUTTON),
                Click.on(MenuHamburgerComponent.LOGIN_BUTTON),
                WaitUntil.the(LoginPage.EMAIL_BOX, isVisible()).forNoMoreThan(4).seconds(),
                Click.on(LoginPage.EMAIL_BOX),
                Enter.theValue(credentials.getUsuario()).into(LoginPage.EMAIL_BOX),
                WaitUntil.the(LoginPage.PASSWORD_BOX, isVisible()).forNoMoreThan(4).seconds(),
                Click.on(LoginPage.PASSWORD_BOX),
                Enter.theValue(credentials.getContrasena()).into(LoginPage.PASSWORD_BOX),
                Click.on(LoginPage.LOGIN_SUBMIT_BUTTON)
        );

        try {
            Thread.sleep(3000); // Espera de 3 segundos para que se complete la acción
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
