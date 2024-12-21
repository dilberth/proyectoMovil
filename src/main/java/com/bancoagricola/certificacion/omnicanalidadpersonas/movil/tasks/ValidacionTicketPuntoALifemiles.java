package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BANNER_BANCO_AGRICOLA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ValidacionTicketPuntoALifemiles implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                VerEnPantalla.elTexto(TXTPRIMER_NOMBRE),
                VerEnPantalla.elTexto(TXTSEGUNDO_NOMBRE),
                VerEnPantalla.elTexto(TXTPRIMER_APELLIDO),
                VerEnPantalla.elTexto(TXSEGUNDO_APELLIDO),
                VerEnPantalla.elTexto(TXTNUMERO_TARJ_LM2),
                VerEnPantalla.elTexto(TXTTOTAL_PUNTOS),
                VerEnPantalla.elTexto(TXTPUNTOS_A_TRANSF2),
                VerEnPantalla.elTexto(TXTCODIGO_PAIS),
                VerEnPantalla.elTexto(TXTNUMERO_TELEFONICO),
                VerEnPantalla.elTexto("Desde"),
                VerEnPantalla.elTexto(TXTESTADO),
                VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
                VerEnPantalla.elTexto(TXTFECHA_APLICADA),
                VerEnPantalla.elTexto(TXTID),
                Click.on(BANNER_BANCO_AGRICOLA)
        );
    }

    public static ValidacionTicketPuntoALifemiles elementos() {
        return Instrumented.instanceOf(ValidacionTicketPuntoALifemiles.class).withProperties();
    }
}