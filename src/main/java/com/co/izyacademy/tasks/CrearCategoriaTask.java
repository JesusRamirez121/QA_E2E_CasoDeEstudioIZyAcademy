package com.co.izyacademy.tasks;

import com.co.izyacademy.models.CrearCategoriaModel;
import com.co.izyacademy.userinterface.CrearCategoriaPage;
import com.co.izyacademy.userinterface.PostPage;
import com.co.izyacademy.utils.DificultadSelectionUtil;
import com.co.izyacademy.utils.EsperaUtil;
import com.co.izyacademy.utils.FileUtil;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearCategoriaTask implements Task {
    private final CrearCategoriaModel data;
    private static final Logger logger = LoggerFactory.getLogger(CrearCategoriaTask.class);

    public CrearCategoriaTask(CrearCategoriaModel data) {
        this.data = data;
    }

    public static Performable crearCategoria(CrearCategoriaModel data) {
        return instrumented(CrearCategoriaTask.class, data);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        logger.info(data.getDescripcion());
        actor.attemptsTo(
                WaitUntil.the(CrearCategoriaPage.TXT_NOMBRE_CATEGORIA, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(CrearCategoriaPage.TXT_NOMBRE_CATEGORIA),
                Enter.theValue(data.getNombreCategoria()).into(CrearCategoriaPage.TXT_NOMBRE_CATEGORIA),
                Hit.the(Keys.TAB).into(CrearCategoriaPage.TXT_NOMBRE_CATEGORIA),
                WaitUntil.the(CrearCategoriaPage.TXT_DESCRIPCION_CATEGORIA, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(data.getDescripcion()).into(CrearCategoriaPage.TXT_DESCRIPCION_CATEGORIA));
        DificultadSelectionUtil.seleccionarDificultad(actor, data.getDificultad());

        // Cargar archivo desde resources
        String rutaArchivo = FileUtil.getResourceFilePath("curso_IA.jpg");
        actor.attemptsTo(
                Upload.theFile(Paths.get(rutaArchivo)).to(CrearCategoriaPage.BTN_SELECCIONAR_ARCHIVO)
        );
        EsperaUtil.esperar(5000);

        actor.attemptsTo(
                Click.on(CrearCategoriaPage.BTN_CREAR_CATEGORIA),
                WaitUntil.the(CrearCategoriaPage.BTN_ENVIAR_DE_TODAS_FORMAS, isVisible()).forNoMoreThan(5).seconds());

        actor.attemptsTo(
                MoveMouse.to(CrearCategoriaPage.BTN_ENVIAR_DE_TODAS_FORMAS),
                Click.on(CrearCategoriaPage.BTN_ENVIAR_DE_TODAS_FORMAS),
                WaitUntil.the(PostPage.BTN_ACCION_A_REALIZAR, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}
