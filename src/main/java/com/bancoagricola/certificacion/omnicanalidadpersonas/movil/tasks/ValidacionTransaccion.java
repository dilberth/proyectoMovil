package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Limites;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static org.junit.Assert.assertTrue;

public class ValidacionTransaccion implements Task {
    private final List<Limites> datos;

    public ValidacionTransaccion(List<Limites> datos) {
        this.datos = datos;
    }

    @Step("{0} valida la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Utilidades.esperar(1);
        if (UiGenerico.elementoQueContengaElTexto(TXTMSG_ERROR2).resolveFor(actor).isVisible()) {

            actor.attemptsTo(
                    Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTMSG_ERROR2)).isDisplayed());

        } else if (UiGenerico.elementoQueContengaElTexto(TXTMSG_ERROR3).resolveFor(actor).isVisible()) {

            actor.attemptsTo(
                    Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTMSG_ERROR3)).isDisplayed());

        } else {

            assertTrue("No se muestra el mensaje: " + "'" + TXTMSG_ERROR2 + "'" + ", favor validar", false);
        }

        actor.attemptsTo(
                VolverInicio.click());
    }

    public static ValidacionTransaccion para(List<Limites> datos) {
        return Instrumented.instanceOf(ValidacionTransaccion.class).withProperties(datos);
    }
}