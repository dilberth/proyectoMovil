package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class ValidacionTicketLimiteTRX implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                VerEnPantalla.elTexto(TXTLIMITES_BM)
        );

        actor.should(seeThat(LimitePorTransaccion.sea(), equalTo(actor.recall(LIMITE_TRX.toString()))).because(actor + " valida que el valor de '" + TXTLIMITE_TRX + "' sea igual a: '$" + actor.recall(LIMITE_TRX.toString()) + "'"));

        actor.attemptsTo(
                VerEnPantalla.elTexto(TXTLIMITES_EBP),
                VerEnPantalla.elTexto(TXTLIMITES_EBP),
                VerEnPantalla.elTexto(TXTESTADO),
                VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
                VerEnPantalla.elTexto(TXTFECHA_APLICADA),
                VerEnPantalla.elTexto(TXTID),
                VolverInicio.click());

    }

    public static ValidacionTicketLimiteTRX elementos() {
        return Instrumented.instanceOf(ValidacionTicketLimiteTRX.class).withProperties();
    }
}
