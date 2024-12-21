package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IngresarEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoTransferenciaTerceroCuentaFavorito implements Task {
    private final List<Cuentas> datos;

    public ProcesoTransferenciaTerceroCuentaFavorito(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia a una cuenta de tercero desde favorito")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(TRANSFERIR).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(TRANSFERIR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TRANSFERIR),
                Esperar.texto("Transferencias"),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())),
                Esperar.texto("Transferencia a terceros"),
                IngresarEn.elCampo(CAMPO_MONTO).elValor(cu.getMonto()),
                IngresarEn.elCampo(CAMPO_CONCEPTO).elValor(cu.getConcepto()),
                Scroll.hastaElElemento(BOTON_CONTINUAR).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(BOTON_CONTINUAR),
                Esperar.texto("¿Deseas continuar?"),
                Click.on(BOTON_ACEPTAR),
                Esperar.texto("La transferencia se realizó exitosamente"));

    }

    public static ProcesoTransferenciaTerceroCuentaFavorito para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaTerceroCuentaFavorito.class).withProperties(datos);
    }
}