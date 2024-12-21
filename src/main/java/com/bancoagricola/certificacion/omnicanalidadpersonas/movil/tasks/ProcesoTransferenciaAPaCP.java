package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoTransferenciaAPaCP implements Task {
    private final List<Ahorros> datos;

    public ProcesoTransferenciaAPaCP(List<Ahorros> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia de ahorro programado a cuenta propia")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros aho = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(TXTOPC_TRANSF)),
                ClickEn.elElemento(UiCuentas.opcionTransferir()),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSFERENCIAS), isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(aho.getCuentaDestino())),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(aho.getCuentaDestino())),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSF_CUE_PROP), isVisible()).forNoMoreThan(30).seconds(),
                IngresarEn.elCampo(TXTMONTO).elValor(aho.getMonto()+ (TargetApp.soIsIos()?"00":"")),
                IngresarEn.elCampo(TXTCONCEPTO).elValor(aho.getConcepto()),
                ClickEnBoton.elElemento(TXTBTN_TRANSF),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF1), isVisible()).forNoMoreThan(45).seconds());

    }

    public static ProcesoTransferenciaAPaCP para(List<Ahorros> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaAPaCP.class).withProperties(datos);
    }
}
