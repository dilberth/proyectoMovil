package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;

public class ClickEnBoton implements Interaction {
    public String element;
    private int cantidadClicks = 1;

    public ClickEnBoton(String element) {
        this.element = element;
    }

    @Step("{0} clicks on '#element'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Scroll.hastaElElemento(UiGenerico.boton(element)).elementoVisibleEnElMedioDeLaPantalla().performAs(actor);
         for (int i = 0; i < this.cantidadClicks; i++) {
            UiGenerico.boton(element).resolveFor(actor).click();
        }
    }

    public static ClickEnBoton elElemento(String element) {
        return Instrumented.instanceOf(ClickEnBoton.class).withProperties(element);
    }

    public ClickEnBoton cantidadDeClicks(int veces) {
        this.cantidadClicks = veces;
        return this;
    }
}
