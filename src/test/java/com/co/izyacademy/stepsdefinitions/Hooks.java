package com.co.izyacademy.stepsdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Managed
    WebDriver hisBrowser;

    @Before
    public void setUp() {
        hisBrowser.manage().window().maximize();
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }

    @After
    public void tearDown() {
        if (hisBrowser != null) {
            hisBrowser.quit();
        }
        OnStage.drawTheCurtain();
    }
}
