package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VolverInicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ValidarTicketTransferenciaQr implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de compra a plazos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto total debitado"),
                VerEnPantalla.elTexto("Transferencia a"),
                VerEnPantalla.elTexto("Concepto"),
                VerEnPantalla.elTexto("Desde"),
                VerEnPantalla.elTexto("Estado"),
                VerEnPantalla.elTexto("Fecha de ordenanza"),
                VerEnPantalla.elTexto("Fecha aplicada"),
                VerEnPantalla.elTexto("ID transacción"),
                VolverInicio.click()
        );
    }

    public static ValidarTicketTransferenciaQr enPantalla(){
        return Tasks.instrumented(ValidarTicketTransferenciaQr.class);
    }

}
