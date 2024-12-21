package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoDeTransferenciaQr implements Task {

    private final List<Cuentas> datos;

    public ProcesoDeTransferenciaQr(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia QR")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(OPCION_TRANSF_QR).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(OPCION_TRANSF_QR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_TRANSF_QR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_TRANSF_QR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPCION_TRANSF_QR),
                Esperar.texto("Transferencia QR"),
                Click.on(UiPagos.codigoNPE()),
                EscribirConJs.elTexto(cu.getCodigoQR()).enElCampo(UiPagos.codigoNPE()),
                Scroll.hastaElElemento(BOTON_ACEPTAR).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(BOTON_ACEPTAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_ACEPTAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BOTON_ACEPTAR),
                Esperar.texto("Transferencia QR"),
                IngresarEn.elCampo(CAMPO_MONTO).elValor(cu.getMonto()),
                Enter.theValue(cu.getConcepto()).into(CAMPO_CONCEPTO),
                Click.on(BOTON_CONTINUAR),
                Esperar.texto("¿Deseas continuar?"),
                Click.on(BOTON_ACEPTAR),
                Esperar.texto("Transferencia QR - Resultado"));
    }

    public static ProcesoDeTransferenciaQr para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoDeTransferenciaQr.class).withProperties(datos);
    }

}