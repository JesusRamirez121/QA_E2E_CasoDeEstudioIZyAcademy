package com.co.izyacademy.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class RegisterPage {
    public static final Target NAME_BOX = Target.the("Name input box")
            .locatedBy("(//input[@id='exampleInputEmail1'])[1]");
    public static final Target USERNAME_BOX = Target.the("Username input box")
            .locatedBy("(//input[@id='exampleInputEmail1'])[2]");
    public static final Target COUNTRY_SELECT = Target.the("Country input box")
            .locatedBy("(//select[@id='exampleInputEmail1'])[1]");
    public static final Target CITY_BOX = Target.the("City input box")
            .locatedBy("(//input[@id='exampleInputEmail1'])[3]");
    public static final Target INDENTIFICATION_NUMBER_BOX = Target.the("Identification number input box")
            .locatedBy("(//input[@id='exampleInputEmail1'])[4]");
    public static final Target PHONE_BOX = Target.the("Phone input box")
            .locatedBy("(//input[@id='exampleInputEmail1'])[5]");
    public static final Target EMAIL_BOX = Target.the("Email input box")
            .locatedBy("(//input[@id='email'])[1]");
    public static final Target PASSWORD_BOX = Target.the("Password input box")
            .locatedBy("(//input[@id='password'])[1]");
    public static final Target CONFIRM_PASSWORD_BOX = Target.the("Confirm password input box")
            .locatedBy("(//input[@id='password-confirm'])[1]");
    public static final Target REGISTER_SUBMIT_BUTTON = Target.the("Register submit button")
            .locatedBy("(//button[normalize-space()='REGISTER'])[1]");

}
