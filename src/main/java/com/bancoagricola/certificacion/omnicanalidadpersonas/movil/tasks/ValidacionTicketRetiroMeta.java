package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BANNER_BANCO_AGRICOLA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ValidacionTicketRetiroMeta implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                VerEnPantalla.elTexto(TXTMONTO_A_RETIRAR),
                VerEnPantalla.elTexto(TXTNOMBRE_META),
                VerEnPantalla.elTexto(TXTMONTO_META2),
                VerEnPantalla.elTexto(TXTMONTO_ACUMULADO),
                VerEnPantalla.elTexto(TXT_CUENTA_RELACIONADA),
                VerEnPantalla.elTexto(TXTESTADO),
                VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
                VerEnPantalla.elTexto(TXTFECHA_APLICADA),
                VerEnPantalla.elTexto(TXTID),
                Click.on(BANNER_BANCO_AGRICOLA));
                //VolverInicio.click());
    }

    public static ValidacionTicketRetiroMeta elementos() {
        return Instrumented.instanceOf(ValidacionTicketRetiroMeta.class).withProperties();
    }
}