package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.ElementNotVisibleException;

public class ElementoEnPantalla implements Interaction {

    private Target elemento;

    public ElementoEnPantalla(Target elemento) {
        this.elemento = elemento;
    }

    @Step("{0} valida la presencia del elemento '#elemento' en pantalla")
    @Override
    public <T extends Actor> void performAs(T actor) {

        if(!elemento.resolveFor(actor).isVisible()){
            throw new ElementNotVisibleException("el elemento '"+elemento+"no se encuentra en pantalla");
        }

    }

    public static ElementoEnPantalla elemento(Target elemento){
        return Tasks.instrumented(ElementoEnPantalla.class,elemento);
    }


}
