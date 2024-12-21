package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ValidarTicketPagoTarjetaTercero implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de tarjeta terceros")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto a pagar"),
                VerEnPantalla.elTexto("Titular"),
                VerEnPantalla.elTexto("Número de tarjeta"),
                VerEnPantalla.elTexto("Correo electrónico"),
                VerEnPantalla.elTexto("Concepto"),
                VerEnPantalla.elTexto("Desde"),
                VerEnPantalla.elTexto("Estado"),
                VerEnPantalla.elTexto("Fecha de ordenanza"),
                VerEnPantalla.elTexto("Fecha aplicada"),
                VerEnPantalla.elTexto("ID transacción"),
                VolverInicio.click()
        );
    }

    public static ValidarTicketPagoTarjetaTercero enPantalla(){
        return Tasks.instrumented(ValidarTicketPagoTarjetaTercero.class);
    }

}
