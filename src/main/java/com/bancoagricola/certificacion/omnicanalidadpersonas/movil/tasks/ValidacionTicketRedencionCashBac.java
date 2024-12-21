package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ValidacionTicketRedencionCashBac implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                VerEnPantalla.elTexto(TXTMONTO),
                VerEnPantalla.elTexto(TXTTIPO_OPERACION),
                VerEnPantalla.elTexto(TXTPRODUCTO_A_ABONAR),
                VerEnPantalla.elTexto(TXTTIPO_COBRO),
                VerEnPantalla.elTexto(TXTCONCEPTO),
                VerEnPantalla.elTexto(TXTESTADO),
                VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
                VerEnPantalla.elTexto(TXTFECHA_APLICADA),
                VerEnPantalla.elTexto(TXTID),
                VolverInicio.click()
        );
    }

    public static ValidacionTicketRedencionCashBac elementos() {
        return Instrumented.instanceOf(ValidacionTicketRedencionCashBac.class).withProperties();
    }
}