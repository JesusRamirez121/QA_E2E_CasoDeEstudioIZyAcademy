package com.co.izyacademy.tasks;

import com.co.izyacademy.models.RegisterModel;
import com.co.izyacademy.userinterface.MenuHamburgerComponent;
import com.co.izyacademy.userinterface.RegisterPage;
import com.co.izyacademy.utils.EsperaUtil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterTask implements Task {
    private final RegisterModel data;

    public RegisterTask(RegisterModel data) {
        this.data = data;
    }

    public static Performable register(RegisterModel data) {
        return instrumented(RegisterTask.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MenuHamburgerComponent.TOOGLE_MENU_HAMBURGER),
                MoveMouse.to(MenuHamburgerComponent.REGISTER_BUTTON),
                Click.on(MenuHamburgerComponent.REGISTER_BUTTON),
                Click.on(RegisterPage.NAME_BOX),
                Enter.theValue(data.getName()).into(RegisterPage.NAME_BOX),
                Click.on(RegisterPage.USERNAME_BOX),
                Enter.theValue(data.getUsername()).into(RegisterPage.USERNAME_BOX),
                Click.on(RegisterPage.COUNTRY_SELECT),
                SendKeys.of(data.getCountry()).into(RegisterPage.COUNTRY_SELECT),
                Click.on(RegisterPage.CITY_BOX),
                Enter.theValue(data.getCity()).into(RegisterPage.CITY_BOX),
                Click.on(RegisterPage.INDENTIFICATION_NUMBER_BOX),
                Enter.theValue(data.getIdNumber()).into(RegisterPage.INDENTIFICATION_NUMBER_BOX),
                Click.on(RegisterPage.PHONE_BOX),
                Enter.theValue(data.getPhone()).into(RegisterPage.PHONE_BOX),
                Click.on(RegisterPage.EMAIL_BOX),
                Enter.theValue(data.getEmail()).into(RegisterPage.EMAIL_BOX),
                Click.on(RegisterPage.PASSWORD_BOX),
                Enter.theValue(data.getPassword()).into(RegisterPage.PASSWORD_BOX),
                Click.on(RegisterPage.CONFIRM_PASSWORD_BOX),
                Enter.theValue(data.getPassword()).into(RegisterPage.CONFIRM_PASSWORD_BOX),
                Click.on(RegisterPage.REGISTER_SUBMIT_BUTTON)
        );
        EsperaUtil.esperar(5000); // Espera de 4 segundos para que se complete el registro
    }
}
