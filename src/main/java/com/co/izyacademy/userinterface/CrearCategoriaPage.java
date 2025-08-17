package com.co.izyacademy.userinterface;

import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;

@NoArgsConstructor
public class CrearCategoriaPage {
    public static final Target TXT_NOMBRE_CATEGORIA = Target.the("Input Nombre Categoria")
            .locatedBy("(//input[@id='exampleInputEmail1'])[1]");
    public static final Target TXT_DESCRIPCION_CATEGORIA = Target.the("Input Descripcion Categoria")
            .locatedBy("(//input[@id='exampleInputEmail1'])[2]");
    public static final Target BTN_SELECCIONAR_ARCHIVO = Target.the("Boton Seleccionar Archivo")
            .locatedBy("(//input[@id='featured'])[1]");
    public static final Target CHECKBOX_EASY = Target.the("Checkbox Easy")
            .locatedBy("(//input[@id='flexRadioDefault1'])[1]");
    public static final Target CHECKBOX_MEDIUM = Target.the("Checkbox Medium")
            .locatedBy("(//input[@id='flexRadioDefault2'])[1]");
    public static final Target CHECKBOX_DIFFICULT = Target.the("Checkbox Difficult")
            .locatedBy("(//input[@id='flexRadioDefault2'])[2]");
    public static final Target BTN_CREAR_CATEGORIA = Target.the("Boton Crear Categoria")
            .locatedBy("(//button[normalize-space()='CREAR'])[1]");
    public  static final Target BTN_ENVIAR_DE_TODAS_FORMAS= Target.the("Boton Enviar de todas formas")
            .locatedBy("(//*[@id='proceed-button'])");
}
