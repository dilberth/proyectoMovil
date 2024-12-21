package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;

public class ValidarTicketPagoPrestamoUni implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de préstamo UNI")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto"),
                VerEnPantalla.elTexto("Banco"),
                VerEnPantalla.elTexto("Préstamo a abonar"),
                VerEnPantalla.elTexto("Tipo de documento"),
//                VerEnPantalla.elTexto("Número de documento"),
//                VerEnPantalla.elTexto("Nombre de recibidor"),
//                VerEnPantalla.elTexto("Correo electrónico"),
//                VerEnPantalla.elTexto("Concepto"),
//                VerEnPantalla.elTexto("Cuenta"),
//                VerEnPantalla.elTexto("Estado"),
//                VerEnPantalla.elTexto("Fecha de ordenanza"),
//                VerEnPantalla.elTexto("Fecha aplicada"),
                VolverInicio.click()
        );
    }

    public static ValidarTicketPagoPrestamoUni enPantalla() {
        return Tasks.instrumented(ValidarTicketPagoPrestamoUni.class);
    }
}