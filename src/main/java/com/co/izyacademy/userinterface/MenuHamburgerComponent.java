package com.co.izyacademy.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuHamburgerComponent {
    public static final Target TOOGLE_MENU_HAMBURGER = Target.the("Toggle menu")
            .locatedBy("(//i[@class='fa-solid fa-bars'])[1]");
    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .located(By.id("Login"));
    public static final Target REGISTER_BUTTON = Target.the("Register button")
            .locatedBy("(//a[normalize-space()='Register'])[1]");
    public static final Target BTN_POSTS = Target.the("Posts button")
            .locatedBy("(//a[@href='https://auto.izyacademy.com/post'])[1]");
}
