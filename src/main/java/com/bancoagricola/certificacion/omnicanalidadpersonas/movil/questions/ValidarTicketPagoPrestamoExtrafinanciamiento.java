package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ValidarTicketPagoPrestamoExtrafinanciamiento implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de préstamo extrafinanciamiento")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto a pagar"),
                VerEnPantalla.elTexto("Extrafinanciamiento"),
                VerEnPantalla.elTexto("Concepto"),
                VerEnPantalla.elTexto("Desde"),
                VerEnPantalla.elTexto("Estado"),
                VerEnPantalla.elTexto("Fecha de ordenanza"),
                VerEnPantalla.elTexto("ID transacción"),
                VolverInicio.click()
        );
    }

    public static ValidarTicketPagoPrestamoExtrafinanciamiento enPantalla(){
        return Tasks.instrumented(ValidarTicketPagoPrestamoExtrafinanciamiento.class);
    }

}
