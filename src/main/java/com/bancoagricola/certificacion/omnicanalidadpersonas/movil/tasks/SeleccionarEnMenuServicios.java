package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.OpcionMenuServicios;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.thucydides.core.annotations.Step;

public class SeleccionarEnMenuServicios implements Task  {

    private final OpcionMenuServicios opcionMenuServicios;

    public SeleccionarEnMenuServicios(OpcionMenuServicios opcionMenuServicios) {
        this.opcionMenuServicios = opcionMenuServicios;
    }

    @Step("{0} selects the #opcionMenuServicios option in the SERVICIOS menu")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Esperar.pantallaDeCarga(),
                Scroll.hastaElElemento(opcionMenuServicios.tomarOpcion()),
                WaitUntil.the(opcionMenuServicios.tomarOpcion(), WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(opcionMenuServicios.tomarOpcion())
        );

    }

    public static SeleccionarEnMenuServicios laOpcion(OpcionMenuServicios opcionesMenuServicios){
        return Tasks.instrumented(SeleccionarEnMenuServicios.class,opcionesMenuServicios);

    }

}
