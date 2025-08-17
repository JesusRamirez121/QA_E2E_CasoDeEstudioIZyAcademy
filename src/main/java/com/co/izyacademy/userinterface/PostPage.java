package com.co.izyacademy.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class PostPage {

    public static final Target BTN_ACCION_A_REALIZAR = Target.the("Click en el boton de que accion desea realizar")
            .locatedBy("(//button[normalize-space()='¿Qué acción deseas realizar?'])[1]");
    public static final Target BTN_CREATE_CATEGORY = Target.the("Click en el boton de crear categoria")
            .locatedBy("(//a[normalize-space()='Create Category'])[1]");
    public static Target divPost(String nombreCategoria) {
        return Target.the("Div de post con nombre " + nombreCategoria)
                .locatedBy("//a[.//h3[contains(normalize-space(text()),'" + nombreCategoria + "')]]");
    }
    public static Target descripcionPost(String nombreCategoria) {
        return Target.the("Descripción del post " + nombreCategoria)
                .locatedBy("//a[.//h3[contains(normalize-space(text()),'" + nombreCategoria + "')]]//p[@class='mt-3']");
    }
}


