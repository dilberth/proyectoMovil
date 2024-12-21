package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ValidarTicketPagoPrestamoPropio implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de préstamo propio")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto del pago"),
                VerEnPantalla.elTexto("Préstamo"),
                VerEnPantalla.elTexto("Fecha de último pago"),
                VerEnPantalla.elTexto("Concepto"),
                VerEnPantalla.elTexto("Comisión por administración"),
//                VerEnPantalla.elTexto("Recargo por mora"),
//                VerEnPantalla.elTexto("Intereses"),
//                VerEnPantalla.elTexto("Amortización"),
//                VerEnPantalla.elTexto("Cuota de ahorro"),
//                VerEnPantalla.elTexto("Cuota de seguro"),
//                VerEnPantalla.elTexto("Honorarios cobro externo"),
//                VerEnPantalla.elTexto("Tasa"),
//                VerEnPantalla.elTexto("int + seg COVID"),
//                VerEnPantalla.elTexto("Saldo anterior"),
                VolverInicio.click()
        );
    }

    public static ValidarTicketPagoPrestamoPropio enPantalla() {
        return Tasks.instrumented(ValidarTicketPagoPrestamoPropio.class);
    }

}
