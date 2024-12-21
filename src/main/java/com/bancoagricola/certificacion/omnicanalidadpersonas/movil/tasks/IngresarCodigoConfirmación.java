package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.AmbienteDePruebas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.EsconderTeclado;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BOTON_CONTINUAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarCodigoConfirmación implements Task {

    @Step("{0} 'ingresa código de confirmación'")
    @Override
    public <T extends Actor> void performAs(T actor) {


        if (!AmbienteDePruebas.isAmbienteQA()) {
            WaitUntil.the(UiInicio.linkObtenerCodigoTelebanca(), isClickable()).forNoMoreThan(20).seconds().performAs(actor);
            Click.on(UiInicio.linkObtenerCodigoTelebanca()).performAs(actor);
        }
        WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTCODIGOCONF), isVisible()).forNoMoreThan(20).seconds().performAs(actor);
        Enter.theValue(TXTCODIGO).into(UiGenerico.campoEditableDespuesDelTexto(TXTCODIGOCONF)).performAs(actor);
        EsconderTeclado.enIos();
        WaitUntil.the(BOTON_CONTINUAR, isClickable()).forNoMoreThan(10).seconds().performAs(actor);
        Click.on(BOTON_CONTINUAR).performAs(actor);
    }


    public static IngresarCodigoConfirmación para() {
        return Instrumented.instanceOf(IngresarCodigoConfirmación.class).withProperties();
    }
}
