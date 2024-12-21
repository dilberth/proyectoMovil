package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ValidacionTicketNotificacionViajeros implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                VerEnPantalla.elTexto(TXTCOMPARTIR_COMPROBANTE),
                VerEnPantalla.elTexto(TXTTARJETAS),
                VerEnPantalla.elTexto(TXTFECHA_SALIDA),
                VerEnPantalla.elTexto(TXTFECHA_REGRESO),
                VerEnPantalla.elTexto(TXTPAISES_DESTINO),
                VerEnPantalla.elTexto(TXT_COMENTARIOS1),
                VerEnPantalla.elTexto(TXTESTADO),
                VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
                VerEnPantalla.elTexto(TXTFECHA_APLICADA),
                VerEnPantalla.elTexto(TXTID)
        );

    }

    public static ValidacionTicketNotificacionViajeros elementos() {
        return Instrumented.instanceOf(ValidacionTicketNotificacionViajeros.class).withProperties();
    }
}