package com.co.izyacademy.stepsdefinitions;

import com.co.izyacademy.exceptions.UnexpectedRedirectionException;
import com.co.izyacademy.questions.DescripcionCategoriaQuestion;
import com.co.izyacademy.tasks.BuscarCategoriaTask;
import com.co.izyacademy.tasks.CrearCategoriaTask;
import com.co.izyacademy.tasks.MenuHamburguesaTask;
import com.co.izyacademy.tasks.PostTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import com.co.izyacademy.models.CrearCategoriaModel;
import com.co.izyacademy.utils.DataTableCrearCategoriaDefinition;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CrearCategoriaStepDefinition {
    @Cuando("^el usuario es direccionado a la url .+$")
    public void elUsuarioEsDireccionadoALaUrl() {
        theActorInTheSpotlight().attemptsTo(MenuHamburguesaTask.openMenuHamburguesa());
    }

    @Cuando("^el usuario hace clic en el botón Crear nueva categoría$")
    public void elUsuarioHaceClicEnElBotón() {
        theActorInTheSpotlight().attemptsTo(PostTask.openPostPage()
        );
    }

    @Y("^crea una nueva categoría con los siguientes datos$")
    public void creaUnaNuevaCategoríaConLosSiguientesDatos(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMaps().get(0);
        DataTableCrearCategoriaDefinition converter = new DataTableCrearCategoriaDefinition();
        CrearCategoriaModel data = converter.crearCategoriaModelEntry(datos);
        theActorInTheSpotlight().attemptsTo(CrearCategoriaTask.crearCategoria(data));
    }

    @Entonces("^el usuario debería ser redirigido a la página de (.+)$")
    public void elUsuarioDeberíaSerRedirigidoALaPágina(String urlpost) {
        String actualUrl = getDriver().getCurrentUrl();
        if (!actualUrl.contains(urlpost)) {
            throw new UnexpectedRedirectionException(urlpost, actualUrl);
        }
        assertThat(actualUrl, containsString(urlpost));
    }

    @Y("^el usuario podra ver la categoría (.+) con descripción (.+)$")
    public void elUsuarioPodraVerLaCategoría(String nombreCategoria, String descripcion) {
        theActorInTheSpotlight().attemptsTo(BuscarCategoriaTask.buscarCategoria(nombreCategoria));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(DescripcionCategoriaQuestion.obtenerDescripcion(), equalTo(descripcion)));
    }

}
