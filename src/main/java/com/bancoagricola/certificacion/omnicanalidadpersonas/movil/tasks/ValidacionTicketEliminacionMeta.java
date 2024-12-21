package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ValidacionTicketEliminacionMeta implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                VerEnPantalla.elTexto(MONTO_TOTAL_DE_META),
                VerEnPantalla.elTexto(TXTNOMBRE_META),
                VerEnPantalla.elTexto(TXTAHORRO_ACUMULADO),
                VerEnPantalla.elTexto(TXTPLAZO),
                VerEnPantalla.elTexto(TXTDIA_RETENCION),
                VerEnPantalla.elTexto(CUOTA_MENSUAL),
                VerEnPantalla.elTexto(TXTCUENTA_A_RELACIONAR),
                VerEnPantalla.elTexto(TXTESTADO),
                VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
                VerEnPantalla.elTexto(TXTFECHA_APLICADA),
                VerEnPantalla.elTexto(TXTID)
        );

    }

    public static ValidacionTicketEliminacionMeta elementos() {
        return Instrumented.instanceOf(ValidacionTicketEliminacionMeta.class).withProperties();
    }
}