package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoTransferenciaTerceroCuentaNueva3 implements Task {
    private final List<Cuentas> datos;

    public ProcesoTransferenciaTerceroCuentaNueva3(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia a una cuenta de tercero")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(TRANSFERIR).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(TRANSFERIR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TRANSFERIR),
                Esperar.texto("Transferencias"),
                Esperar.texto("Transferir a tercero"),
                Click.on(UiGenerico.elementoQueContengaElTexto("Transferir a tercero")),
                Esperar.texto("Transferencia a terceros"),
                Task.where("Click",Click.on(CAMPO_NUMERO_CUENTA)).withNoReporting(),
                Enter.theValue(cu.getCuentaTercero()).into(CAMPO_NUMERO_CUENTA),
                Task.where("Click",Click.on(CAMPO_CORREO)).withNoReporting(),
                Enter.theValue(cu.getCorreo()).into(CAMPO_CORREO),
                Task.where("Click",Click.on(CAMPO_MONTO_TT)).withNoReporting(),
                Enter.theValue(cu.getMonto()).into(CAMPO_MONTO_TT),
                Task.where("Click",Click.on(CAMPO_CONCEPTO)).withNoReporting(),
                Enter.theValue(cu.getConcepto()).into(CAMPO_CONCEPTO),
                Scroll.simple(),
                Click.on(BOTON_CONTINUAR),
                Esperar.texto("¿Deseas continuar?", 10),
                Click.on(BOTON_ACEPTAR));
    }

    public static ProcesoTransferenciaTerceroCuentaNueva3 para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaTerceroCuentaNueva3.class).withProperties(datos);
    }
}
