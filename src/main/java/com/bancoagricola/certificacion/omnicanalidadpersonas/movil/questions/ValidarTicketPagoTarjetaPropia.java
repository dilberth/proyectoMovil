package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ValidarTicketPagoTarjetaPropia implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de tarjeta propia")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto del pago"),
                VerEnPantalla.elTexto("Tarjeta"),
                VerEnPantalla.elTexto("Concepto"),
                VerEnPantalla.elTexto("Desde"),
                VerEnPantalla.elTexto("Estado"),
                VerEnPantalla.elTexto("Fecha de ordenanza"),
                VerEnPantalla.elTexto("Fecha aplicada"),
                VerEnPantalla.elTexto("ID transacción"),
                VolverInicio.click()
        );
    }

    public static ValidarTicketPagoTarjetaPropia enPantalla() {
        return Tasks.instrumented(ValidarTicketPagoTarjetaPropia.class);
    }

}
