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

public class ValidacionTicketUNI implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                VerEnPantalla.elTexto(TXTMONTO),
                VerEnPantalla.elTexto(TXTTIPOCUENTA),
                VerEnPantalla.elTexto(TXTCUENTATRANSFERIR),
                VerEnPantalla.elTexto(TXTTIPODOCUMEN),
                VerEnPantalla.elTexto(TXTNUMERODOCU),
                VerEnPantalla.elTexto(TXTNOMBRE_RECIBIDOR2),
                VerEnPantalla.elTexto(TXTCORREO),
                //VerEnPantalla.elTexto(TXTCONCEPTO),
                VerEnPantalla.elTexto(TXTCOMISION_ACH),
                VerEnPantalla.elTexto(TXTCUENTA),
                //VerEnPantalla.elTexto(TXTESTADO),
                //VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
                //VerEnPantalla.elTexto(TXTFECHA_APLICADA),
                //VerEnPantalla.elTexto(TXTID),
                Click.on(BANNER_BANCO_AGRICOLA));
    }

    public static ValidacionTicketUNI elementos() {
        return Instrumented.instanceOf(ValidacionTicketUNI.class).withProperties();
    }
}
