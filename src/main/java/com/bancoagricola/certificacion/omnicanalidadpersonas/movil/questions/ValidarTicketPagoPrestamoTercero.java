package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ValidarTicketPagoPrestamoTercero implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de préstamo terceros")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto del pago"),
                VerEnPantalla.elTexto("Titular"),
                VerEnPantalla.elTexto("Número de préstamo"),
                VerEnPantalla.elTexto("Correo electrónico"),
                VerEnPantalla.elTexto("Concepto"),
                VerEnPantalla.elTexto("Comisión por administración"),
                VerEnPantalla.elTexto("Recargo por mora"),
                VerEnPantalla.elTexto("Intereses"),
//                VerEnPantalla.elTexto("Amortización"),
//                VerEnPantalla.elTexto("Cuota de ahorro"),
//                VerEnPantalla.elTexto("Cuota de seguro"),
//                VerEnPantalla.elTexto("Honorarios cobro externo"),
//                VerEnPantalla.elTexto("Tasa"),
//                VerEnPantalla.elTexto("Saldo anterior"),
//                VerEnPantalla.elTexto("Saldo actual"),
                VolverInicio.click()
        );
    }

    public static ValidarTicketPagoPrestamoTercero enPantalla(){
        return Tasks.instrumented(ValidarTicketPagoPrestamoTercero.class);
    }

}
