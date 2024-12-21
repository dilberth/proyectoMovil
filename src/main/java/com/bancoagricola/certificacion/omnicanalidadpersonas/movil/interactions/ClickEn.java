package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.Scroll;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class ClickEn implements Task {

    private Target elemento;
    private int cantidadClicks = 1;

    public ClickEn(Target elemento) {
        this.elemento = elemento;
    }

    //@Step("{0} clicks #cantidadClicks times in the elements")
    @Step("{0} da click en #elemento")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Scroll.hastaElElemento(elemento).performAs(actor);
        for (int i = 0; i < this.cantidadClicks; i++) {
            Click.on(elemento.getClass().toString().contains("XPathOrCssTarget")?elemento.of(Utilidades.obtenerDeTargetLaPropiedad(elemento, TargetApp.soIsIos()?"label":"text")):elemento).performAs(actor);
        }
        Esperar.pantallaDeCarga().performAs(actor);
    }

    public static ClickEn elElemento(Target elemento) {
        return Tasks.instrumented(ClickEn.class, elemento);
    }

    public ClickEn cantidadDeClicks(int veces) {
        this.cantidadClicks = veces;
        return this;
    }

}
