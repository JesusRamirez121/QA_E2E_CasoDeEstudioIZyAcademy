package com.co.izyacademy.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class UsuarioComponent {
    public static final Target BTN_USER = Target.the("Click al elemento user")
            .locatedBy("//button[@type='button']");
    public static final Target COMPARE = Target.the("Compare name")
            .locatedBy("//*[contains(@class, 'dropdown-item fw-normal fs-6 ms-1')]");
}
