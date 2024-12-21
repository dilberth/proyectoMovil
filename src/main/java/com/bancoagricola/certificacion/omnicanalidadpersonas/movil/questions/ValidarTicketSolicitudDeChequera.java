package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ValidarTicketSolicitudDeChequera implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de compra a plazos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Tipo de chequera"),
                VerEnPantalla.elTexto("Número de chequeras"),
                VerEnPantalla.elTexto("Cantidad de cheques"),
                VerEnPantalla.elTexto("Departamento"),
                VerEnPantalla.elTexto("Agencia"),
                VerEnPantalla.elTexto("Cuenta")
//                VerEnPantalla.elTexto("Estado"),
//                VerEnPantalla.elTexto("Fecha de ordenanza"),
//                VerEnPantalla.elTexto("Fecha aplicada"),
//                VerEnPantalla.elTexto("ID transacción")
        );
    }

    public static ValidarTicketSolicitudDeChequera enPantalla(){
        return Tasks.instrumented(ValidarTicketSolicitudDeChequera.class);
    }

}
