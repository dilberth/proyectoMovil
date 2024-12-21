package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;

public class ValidarTicketPagoTarjetaUni implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de tarjeta terceros")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto"),
                VerEnPantalla.elTexto("Banco"),
                VerEnPantalla.elTexto("Tarjeta a abonar"),
                VerEnPantalla.elTexto("Tipo de documento"),
                VerEnPantalla.elTexto("Número de documento"),
                VerEnPantalla.elTexto("Nombre de recibidor"),
                VerEnPantalla.elTexto("Correo electrónico"),
                VerEnPantalla.elTexto("Concepto"),
                VerEnPantalla.elTexto("Comisión ACH"),
                VerEnPantalla.elTexto("Desde"),
                VolverInicio.click()
        );
    }

    public static ValidarTicketPagoTarjetaUni enPantalla(){
        return Tasks.instrumented(ValidarTicketPagoTarjetaUni.class);
    }

}
