package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.CANTIDAD_MOVIMIENTOS_AHORROS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.*;

public class MovimientosFechaAhorros implements Task {
    private final List<Ahorros> datos;

    public MovimientosFechaAhorros(List<Ahorros> datos) {
        this.datos = datos;
    }

    @Step("{0} valida movimientos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros cu = datos.get(0);

        actor.attemptsTo(
                Scroll.hastaElElemento(UiCuentas.menuCuentas()));
        ScrollVertical.corto().ejecutar();
        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isClickable()).forNoMoreThan(20).seconds(),
                Click.on(UiCuentas.menuCuentas()),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTFILTAR), isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTFILTAR), isEnabled()).forNoMoreThan(20).seconds(),
                ClickEnEnlace.deNombre(TXTFILTAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTSEMANA_ACTUAL), isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(UiCalendario.fechaCalendarioDesde(),isClickable()).forNoMoreThan(30).seconds(),
                SeleccionarEnCalendario.laFechaDesde(cu.getFechaDesde()),
                WaitUntil.the(UiCalendario.fechaCalendarioHasta(),isClickable()).forNoMoreThan(30).seconds(),
                SeleccionarEnCalendario.laFechaHasta(cu.getFechaHasta()),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(TXTBTNBUSCAR_MOVIMIENTOS)),
                Click.on(UiGenerico.elementoQueContengaElTexto(TXTBTNBUSCAR_MOVIMIENTOS)),
                Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTNO_MOVIMIENTOS)).isNotDisplayed(),
                WaitUntil.the(CANTIDAD_MOVIMIENTOS_AHORROS, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(CANTIDAD_MOVIMIENTOS_AHORROS, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(CANTIDAD_MOVIMIENTOS_AHORROS, isClickable()).forNoMoreThan(20).seconds());
        System.out.println("Cantidad de movimientos: " + CANTIDAD_MOVIMIENTOS_AHORROS.resolveAllFor(actor).size());
        actor.should(seeThat(CantidadMovimientosAhorros.tiene(), greaterThanOrEqualTo(1)).because(actor + " valida que la cantidad de movimientos sea mayor o igual a 1"));
    }

    public static MovimientosFechaAhorros para(List<Ahorros> datos) {
        return Instrumented.instanceOf(MovimientosFechaAhorros.class).withProperties(datos);
    }
}