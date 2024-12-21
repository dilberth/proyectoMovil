package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VolverInicio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.VerEnPantalla;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ValidacionTicketPagoAUnAmigo implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto(TXTMONTO_A_PAGAR),
                VerEnPantalla.elTexto(TXTCONCEPTO),
                VerEnPantalla.elTexto("Cuenta destino"),
                VerEnPantalla.elTexto(TXTCUENTA),
//                VerEnPantalla.elTexto(TXTESTADO),
//                VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
//                VerEnPantalla.elTexto(TXTFECHA_APLICADA),
//                VerEnPantalla.elTexto(TXTID),
                VolverInicio.click()
        );
    }

    public static ValidacionTicketPagoAUnAmigo elementos() {
        return Instrumented.instanceOf(ValidacionTicketPagoAUnAmigo.class).withProperties();
    }
}