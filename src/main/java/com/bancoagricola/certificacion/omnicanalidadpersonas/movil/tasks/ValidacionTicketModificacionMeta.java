package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ValidacionTicketModificacionMeta implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                VerEnPantalla.elTexto(MONTO_TOTAL_DE_META),
                VerEnPantalla.elTexto(TXTNOMBRE_META),
                VerEnPantalla.elTexto(TXTMONTO_ACUMULADO),
                VerEnPantalla.elTexto(TXTPLAZO_META),
                VerEnPantalla.elTexto(TXTDIA_RETENCION),
                VerEnPantalla.elTexto(TXTPLAZO_TRANSCURRIDO),
                VerEnPantalla.elTexto(CUOTA_MENSUAL),
                VerEnPantalla.elTexto(CUENTA_PARA_RETENCIÓN_DE_CUOTA),
                VerEnPantalla.elTexto(TXTESTADO),
                VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
                VerEnPantalla.elTexto(TXTFECHA_APLICADA),
                VerEnPantalla.elTexto(TXTID),
                VolverInicio.click()
        );

    }

    public static ValidacionTicketModificacionMeta elementos() {
        return Instrumented.instanceOf(ValidacionTicketModificacionMeta.class).withProperties();
    }
}