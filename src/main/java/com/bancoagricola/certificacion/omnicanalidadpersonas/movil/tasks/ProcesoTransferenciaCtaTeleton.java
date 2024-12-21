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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProcesoTransferenciaCtaTeleton implements Task {
    private final List<Cuentas> datos;

    public ProcesoTransferenciaCtaTeleton(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de 'transferencia a cuenta Teletón'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(OPCION_TRANSF_TELETON).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(OPCION_TRANSF_TELETON),
                WaitUntil.the(AYUDA_TELETON, isVisible()).forNoMoreThan(80).seconds(),
                IngresarEn.elCampo(CAMPO_MONTO).elValor(cu.getMonto()),
                IngresarEn.elCampo(CAMPO_CONCEPTO).elValor(cu.getMonto()),
                Scroll.hastaElElemento(BOTON_CONTINUAR).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(BOTON_CONTINUAR),
                Esperar.texto("¿Deseas continuar?", 5),
                Click.on(BOTON_ACEPTAR),
                Esperar.texto("La transferencia se realizó exitosamente", 30));

    }

    public static ProcesoTransferenciaCtaTeleton para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaCtaTeleton.class).withProperties(datos);
    }
}