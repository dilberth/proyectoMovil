package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.CANTIDAD_MOVIMIENTOS_PRESTAMOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.*;

public class MovimientosFechaPrestamos implements Task {
    private final List<Cuentas> datos;

    public MovimientosFechaPrestamos(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida movimientos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Scroll.hastaElElemento(UiCuentas.menuCuentas()).elementoVisibleEnElMedioDeLaPantalla(),
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
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(TXTBTNBUSCAR_MOVIMIENTOS)).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(UiGenerico.elementoQueContengaElTexto(TXTBTNBUSCAR_MOVIMIENTOS)),
                Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTNO_MOVIMIENTOS)).isNotDisplayed(),
                WaitUntil.the(CANTIDAD_MOVIMIENTOS_PRESTAMOS, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(CANTIDAD_MOVIMIENTOS_PRESTAMOS, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(CANTIDAD_MOVIMIENTOS_PRESTAMOS, isClickable()).forNoMoreThan(20).seconds());
        System.out.println("Cantidad de movimientos: " + CANTIDAD_MOVIMIENTOS_PRESTAMOS.resolveAllFor(actor).size());
        actor.should(seeThat(CantidadMovimientosPrestamos.tiene(), greaterThanOrEqualTo(1)).because(actor + " valida que la cantidad de movimientos sea mayor o igual a 1"));
    }

    public static MovimientosFechaPrestamos para(List<Cuentas> datos) {
        return Instrumented.instanceOf(MovimientosFechaPrestamos.class).withProperties(datos);
    }
}