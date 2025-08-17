package com.co.izyacademy.stepsdefinitions;

import com.co.izyacademy.exceptions.UnexpectedRedirectionException;
import com.co.izyacademy.models.RegisterModel;
import com.co.izyacademy.questions.CompareName;
import com.co.izyacademy.tasks.RegisterTask;
import com.co.izyacademy.utils.Constants;
import com.co.izyacademy.utils.DataTableRegisterDefinition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.core.environment.WebDriverConfiguredEnvironment.getEnvironmentVariables;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class RegisterStepDefinition {


    @Dado("^que el usuario ingresa a la página web$")
    public void queElUsuarioIngresaALaPáginaWeb() {
        String webServiceEndpoint = EnvironmentSpecificConfiguration
                .from(getEnvironmentVariables())
                .getProperty("environments.default.webdriver.base.url");
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(webServiceEndpoint));
    }

    @Cuando("^el usuario completa el formulario de registro con los siguientes datos$")
    public void elUsuarioCompletaElFormularioDeRegistroConLosSiguientesDatos(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMaps().get(0);
        DataTableRegisterDefinition converter = new DataTableRegisterDefinition();
        RegisterModel data = converter.registerModelEntry(datos);

        theActorInTheSpotlight().attemptsTo(RegisterTask.register(data));
    }

    @Entonces("^el usuario debería ser redirigido a la página correcta$")
    public void elUsuarioDeberiaSerRedirigidoALaPaginaCorrecta() {
        String actualUrl = getDriver().getCurrentUrl();

        if (!actualUrl.contains(Constants.URL)) {
            throw new UnexpectedRedirectionException(Constants.URL, actualUrl);
        }
        assertThat(actualUrl, containsString(Constants.URL));
    }

    @Entonces("^el usuario podra ver su username (.+)$")
    public void elUsuarioPodraVerSuNombre(String username) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CompareName.compare(),
                Matchers.is(containsString(username))));
    }
}