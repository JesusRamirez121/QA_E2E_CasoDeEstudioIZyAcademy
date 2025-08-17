package com.co.izyacademy.tasks;

import com.co.izyacademy.userinterface.PostPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PostTask implements Task {

    public static PostTask openPostPage() {
        return new PostTask();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PostPage.BTN_ACCION_A_REALIZAR, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(PostPage.BTN_ACCION_A_REALIZAR),
                WaitUntil.the(PostPage.BTN_CREATE_CATEGORY, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(PostPage.BTN_CREATE_CATEGORY)
        );
    }


}
