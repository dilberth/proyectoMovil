package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Ahorros;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.Scroll;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.ScrollVertical;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerMasAhorros implements Interaction {
    private List<Ahorros> datos;

    public VerMasAhorros(List<Ahorros> datos) {
        this.datos = datos;
    }

    @Step("{0} selecciona producto e ingresa a la opción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros aho = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiAhorros.menuMetas(), isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(UiAhorros.menuMetas(), isClickable()).forNoMoreThan(20).seconds(),
                Click.on(UiAhorros.menuMetas()),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(aho.getCuentaOrigen())),
                Scroll.hastaElElemento(UiAhorros.numeroDeCuenta(aho.getCuentaOrigen())));
        ScrollVertical.mini().ejecutar();
        if (!UiMenuServicios.opcionesVerMasActiva(aho.getCuentaOrigen()).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(UiGenerico.elementoQueContengaElTexto(aho.getCuentaOrigen())));
        }
        actor.attemptsTo(
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()));
        ScrollVertical.mini().ejecutar();
        actor.attemptsTo(
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(20).seconds());
    }

    public static VerMasAhorros para(List<Ahorros> datos) {
        return Instrumented.instanceOf(VerMasAhorros.class).withProperties(datos);
    }
}