package com.co.izyacademy.tasks;

import com.co.izyacademy.userinterface.MenuHamburgerComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MenuHamburguesaTask implements Task {
    public static MenuHamburguesaTask openMenuHamburguesa() {
        return new MenuHamburguesaTask();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MenuHamburgerComponent.TOOGLE_MENU_HAMBURGER, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(MenuHamburgerComponent.TOOGLE_MENU_HAMBURGER),
                MoveMouse.to(MenuHamburgerComponent.BTN_POSTS),
                Click.on(MenuHamburgerComponent.BTN_POSTS));
    }


}
