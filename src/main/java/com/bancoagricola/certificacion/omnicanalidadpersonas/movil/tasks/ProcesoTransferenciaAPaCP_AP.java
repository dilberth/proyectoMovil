package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiAhorros.MENU_METAS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.TITULO_TRANSFERENCIAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoTransferenciaAPaCP_AP implements Task {
    private final Ahorros aho;

    public ProcesoTransferenciaAPaCP_AP(List<Ahorros> datos) {
        this.aho = datos.get(0);
    }

    @Step("{0} realiza el proceso de transferencia de ahorro programado a cuenta propia")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(MENU_METAS, isEnabled()).forNoMoreThan(30).seconds(),
                Click.on(MENU_METAS),
                Scroll.hastaElElemento(PRODUCTO(aho.getCuentaOrigen())).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(PRODUCTO(aho.getCuentaOrigen()), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PRODUCTO(aho.getCuentaOrigen()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PRODUCTO(aho.getCuentaOrigen()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(PRODUCTO(aho.getCuentaOrigen())),
                Scroll.hastaElElemento(VER_MAS).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(VER_MAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(VER_MAS),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(TRANSFERIR).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(TRANSFERIR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TRANSFERIR),
                WaitUntil.the(TITULO_TRANSFERENCIAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TITULO_TRANSFERENCIAS, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(SEL_CUENTA(aho.getCuentaDestino())).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(SEL_CUENTA(aho.getCuentaDestino()), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SEL_CUENTA(aho.getCuentaDestino()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SEL_CUENTA(aho.getCuentaDestino()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SEL_CUENTA(aho.getCuentaDestino())),
                WaitUntil.the(TITULO_TRANSFERENCIAS_CP, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TITULO_TRANSFERENCIAS_CP, isEnabled()).forNoMoreThan(30).seconds(),
                Enter.theValue(aho.getMonto()).into(CAMPO_MONTO),
                Enter.theValue(aho.getConcepto()).into(CAMPO_CONCEPTO),
                Click.on(BOTON_TRANSFERIR),
                WaitUntil.the(CONFIRMACION_TRANSF, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(CONFIRMACION_TRANSF, isEnabled()).forNoMoreThan(30).seconds());
/*
        actor.attemptsTo(

                IrAProducto.ahorros(aho.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.TRANSFERIR.tomarTransaccion()),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSFERENCIAS), isVisible()).forNoMoreThan(30).seconds(),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(aho.getCuentaDestino())),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSF_CUE_PROP), isVisible()).forNoMoreThan(30).seconds(),
                IngresarEn.elCampo(TXTMONTO).elValor(aho.getMonto()),
                IngresarEn.elCampo(TXTCONCEPTO).elValor(aho.getConcepto()),
                ClickEnBoton.elElemento(TXTBTN_TRANSF),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF1), isVisible()).forNoMoreThan(45).seconds(),
                VolverInicio.click()

        );

 */
    }

    public static ProcesoTransferenciaAPaCP_AP para(List<Ahorros> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaAPaCP_AP.class).withProperties(datos);
    }
}
