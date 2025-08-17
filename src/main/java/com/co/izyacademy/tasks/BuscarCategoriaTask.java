package com.co.izyacademy.tasks;

import com.co.izyacademy.userinterface.PostPage;
import com.co.izyacademy.utils.EsperaUtil;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarCategoriaTask implements Task {
    private final String nombreCategoria;
    private static final Logger logger = LoggerFactory.getLogger(BuscarCategoriaTask.class);
    public BuscarCategoriaTask(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public static Performable buscarCategoria(String nombreCategoria) {
        return instrumented(BuscarCategoriaTask.class, nombreCategoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PostPage.BTN_ACCION_A_REALIZAR, isVisible()).forNoMoreThan(8).seconds()
        );

        int maxScrolls = 10;
        int currentScroll = 0;
        boolean elementFound = false;

        while (currentScroll < maxScrolls && !elementFound) {
            try {
                actor.attemptsTo(
                        WaitUntil.the(PostPage.divPost(nombreCategoria), isVisible())
                                .forNoMoreThan(2).seconds()
                );
                elementFound = true;
            } catch (Exception e) {
                actor.attemptsTo(
                        Scroll.to("{window.scrollBy(0, 500);}")
                );
                currentScroll++;
            }
        }

        if (elementFound) {
            String descripcionDetallada = actor.asksFor(Text.of(PostPage.descripcionPost(nombreCategoria)));
            Serenity.setSessionVariable("descripcionDetallada").to(descripcionDetallada);

            actor.attemptsTo(
                    WaitUntil.the(PostPage.divPost(nombreCategoria), isVisible())
                            .forNoMoreThan(5).seconds(),
                    Scroll.to(PostPage.divPost(nombreCategoria)),
                    JavaScriptClick.on(PostPage.divPost(nombreCategoria))
            );
        } else {
            throw new RuntimeException("No se encontró la categoría después de hacer scroll: " + nombreCategoria);
        }

        EsperaUtil.esperar(6000);
    }
}
