package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Tarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.CONFIRMACION_TRANSF;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ProcesoTransferenciaTCaCP implements Task {
    private final List<Tarjetas> datos;

    public ProcesoTransferenciaTCaCP(List<Tarjetas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia de tarjeta de credito a cuenta propia")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Tarjetas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(TRANSFERIR).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(TRANSFERIR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TRANSFERIR),
                WaitUntil.the(TITULO_TRANSFERENCIAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TITULO_TRANSFERENCIAS, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(SEL_CUENTA(cu.getCuentaDestino())).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(SEL_CUENTA(cu.getCuentaDestino()), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SEL_CUENTA(cu.getCuentaDestino()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SEL_CUENTA(cu.getCuentaDestino()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SEL_CUENTA(cu.getCuentaDestino())),
                WaitUntil.the(TITULO_TRANSFERENCIAS_CP, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TITULO_TRANSFERENCIAS_CP, isEnabled()).forNoMoreThan(30).seconds(),
                Enter.theValue(cu.getMonto()).into(CAMPO_MONTO),
                Enter.theValue(cu.getConcepto()).into(CAMPO_CONCEPTO),
                Click.on(BOTON_TRANSFERIR),
                WaitUntil.the(CONFIRMACION_TRANSF, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CONFIRMACION_TRANSF, isEnabled()).forNoMoreThan(60).seconds());
    }

    /*
        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                ClickEn.elElemento(UiCuentas.opcionTransferir()),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(tarj.getCuentaDestino())),
                Click.on(UiGenerico.elementoQueContengaElTexto(tarj.getCuentaDestino())),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSF_CUE_PROP), isVisible()).forNoMoreThan(30).seconds(),
                IngresarEn.elCampo(TXTMONTO).elValor(tarj.getMonto()+ (TargetApp.soIsIos()?"00":"")),
                IngresarEn.elCampo(TXTCONCEPTO).elValor(tarj.getConcepto()),
                ClickEnBoton.elElemento(TXTBTN_TRANSF),
                Esperar.texto(TXTDESEA_CONTINUAR),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF1), isVisible()).forNoMoreThan(45).seconds()
                );

     */

    public static ProcesoTransferenciaTCaCP para(List<Tarjetas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaTCaCP.class).withProperties(datos);
    }
}
