package com.co.izyacademy.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target EMAIL_BOX = Target.the("Email input box")
            .located(By.xpath("(//input[@id='exampleInputEmail1'])[1]"));
    public static final Target PASSWORD_BOX = Target.the("Password input box")
            .located(By.xpath("(//input[@id='exampleInputPassword1'])[1]"));
    public static final Target LOGIN_SUBMIT_BUTTON = Target.the("Login submit button")
            .located(By.id("effect-button"));
    public static final Target BTN_USER = Target.the("Click al elemento user")
            .located(By.xpath("//button[@type='button']"));
    public static final Target Compare = Target.the("Comparar nombre")
            .located(By.xpath("//*[contains(@class, 'dropdown-item fw-normal fs-6 ms-1')]"));
}
