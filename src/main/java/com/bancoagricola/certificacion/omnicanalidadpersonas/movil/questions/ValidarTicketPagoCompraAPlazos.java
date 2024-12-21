package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.ScrollVertical;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ValidarTicketPagoCompraAPlazos implements Task {

    @Step("{0} valida que se observen todos los campos que componene el ticket de pago de compra a plazos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto del pago"),
                VerEnPantalla.elTexto("Selecciona compras a plazo"),
                VerEnPantalla.elTexto("Tarjeta"),
                VerEnPantalla.elTexto("Fecha de pago"),
                VerEnPantalla.elTexto("Última fecha de pago"),
                VerEnPantalla.elTexto("Concepto"),
                VerEnPantalla.elTexto("Desde"),
                VerEnPantalla.elTexto("Estado"),
                VerEnPantalla.elTexto("Fecha de ordenanza"),
                VerEnPantalla.elTexto("Fecha aplicada"),
                VerEnPantalla.elTexto("ID transacción"),
                VolverInicio.click()
        );
    }

    public static ValidarTicketPagoCompraAPlazos enPantalla(){
        return Tasks.instrumented(ValidarTicketPagoCompraAPlazos.class);
    }

}