package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ValidarTicketPagoTarjetaTransfer365 implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de tarjeta transfer365")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto"),
                VerEnPantalla.elTexto("Institución destino"),
                VerEnPantalla.elTexto("Tarjeta a abonar"),
                VerEnPantalla.elTexto("Tipo de cliente recibidor"),
                VerEnPantalla.elTexto("Nombre del recibidor"),
                VerEnPantalla.elTexto("Apellido del recibidor"),
                VerEnPantalla.elTexto("Correo electrónico"),
//                VerEnPantalla.elTexto("Concepto"),
//                VerEnPantalla.elTexto("Cuenta"),
//                VerEnPantalla.elTexto("Estado"),
//                VerEnPantalla.elTexto("Fecha de ordenanza"),
//                VerEnPantalla.elTexto("Fecha aplicada"),
//                VerEnPantalla.elTexto("ID transacción"),
                VolverInicio.click()
        );
    }

    public static ValidarTicketPagoTarjetaTransfer365 enPantalla(){
        return Tasks.instrumented(ValidarTicketPagoTarjetaTransfer365.class);
    }

}
