package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.Scroll;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class VerMasCuentasDest implements Interaction {
    private List<Cuentas> datos;

    public VerMasCuentasDest(List<Cuentas> datos) {
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
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getCuentaDestino())).elementoVisibleEnElMedioDeLaPantalla());
        if (!UiMenuServicios.opcionesVerMasActiva(cu.getCuentaDestino()).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getCuentaDestino())));
        }
        actor.attemptsTo(
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()),
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(30).seconds());
    }

    public static VerMasCuentasDest para(List<Cuentas> datos) {
        return Instrumented.instanceOf(VerMasCuentasDest.class).withProperties(datos);
    }
}