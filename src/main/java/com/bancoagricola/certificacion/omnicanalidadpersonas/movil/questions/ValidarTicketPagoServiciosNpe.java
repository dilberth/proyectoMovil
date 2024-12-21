package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ValidarTicketPagoServiciosNpe implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago servicios NPE")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto a abonar"),
                VerEnPantalla.elTexto("Recibo"),
                VerEnPantalla.elTexto("NPE"),
                VerEnPantalla.elTexto("Desde"),
                VerEnPantalla.elTexto("Estado"),
//                VerEnPantalla.elTexto("Fecha de ordenanza"),
//                VerEnPantalla.elTexto("Fecha aplicada"),
//                VerEnPantalla.elTexto("ID transacción"),
                VolverInicio.click()
                );
    }

    public static ValidarTicketPagoServiciosNpe enPantalla(){
        return Tasks.instrumented(ValidarTicketPagoServiciosNpe.class);
    }

}
