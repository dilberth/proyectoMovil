package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
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

public class VerMasCuentas implements Interaction {
    private List<Cuentas> datos;

    public VerMasCuentas(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} selecciona producto e ingresa a la opción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(UiCuentas.menuCuentas(), isClickable()).forNoMoreThan(20).seconds(),
                Click.on(UiCuentas.menuCuentas()),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getCuentaOrigen())),
                Scroll.hastaElElemento(UiCuentas.numeroCuenta1Ca(cu.getCuentaOrigen())));
        ScrollVertical.mini().ejecutar();
        if (!UiMenuServicios.opcionesVerMasActiva(cu.getCuentaOrigen()).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getCuentaOrigen()))
            );
        }
        actor.attemptsTo(
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()));
        ScrollVertical.mini().ejecutar();
        actor.attemptsTo(
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(30).seconds());
    }

    public static VerMasCuentas para(List<Cuentas> datos) {
        return Instrumented.instanceOf(VerMasCuentas.class).withProperties(datos);
    }
}