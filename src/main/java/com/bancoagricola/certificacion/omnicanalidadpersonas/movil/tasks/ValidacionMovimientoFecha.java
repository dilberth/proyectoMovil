package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiAhorros.MENU_METAS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas.MENU_TARJETAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidacionMovimientoFecha implements Task {
    private final List<Cuentas> datos;

    public ValidacionMovimientoFecha(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida que se muestren los movimientos para la cuenta seleccionada")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        if (cu.getOpcion().equals("CA") || cu.getOpcion().equals("CC") || cu.getOpcion().equals("ADS") || cu.getOpcion().equals("PRE") || cu.getOpcion().equals("FDI") || cu.getOpcion().equals("EXT")) {
            actor.attemptsTo(
                    WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(30).seconds());
        } else if (cu.getOpcion().equals("AP")) {
            actor.attemptsTo(
                    WaitUntil.the(MENU_METAS, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(MENU_METAS, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(MENU_METAS));
        } else if (cu.getOpcion().equals("TDC") || cu.getOpcion().equals("PBA")) {
            actor.attemptsTo(
                    WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(MENU_TARJETAS),
                    Esperar.pantallaDeCarga());
        } else {
            System.out.println("Opción no válida");
        }

        actor.attemptsTo(
                Scroll.hastaElElemento(PRODUCTO(cu.getCuentaOrigen())).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(PRODUCTO(cu.getCuentaOrigen()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PRODUCTO(cu.getCuentaOrigen()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(PRODUCTO(cu.getCuentaOrigen())),
                Scroll.hastaElElemento(VER_MAS).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(VER_MAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(VER_MAS),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(OPCION_MOVIMIENTOS).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(OPCION_MOVIMIENTOS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_MOVIMIENTOS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_MOVIMIENTOS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPCION_MOVIMIENTOS));

        if (cu.getOpcion().equals("CA") || cu.getOpcion().equals("CC") || cu.getOpcion().equals("ADS") || cu.getOpcion().equals("AP") || cu.getOpcion().equals("PRE") || cu.getOpcion().equals("FDI") || cu.getOpcion().equals("EXT")) {
            actor.attemptsTo(
                    WaitUntil.the(MES_ACTUAL_FILTRAR, isEnabled()).forNoMoreThan(90).seconds(),
                    WaitUntil.the(MES_ACTUAL_FILTRAR, isClickable()).forNoMoreThan(90).seconds(),
                    ClickEnEnlace.deNombre("Filtrar"));
        } else if (cu.getOpcion().equals("TDC")) {
            actor.attemptsTo(
                    ClickEnEnlace.deNombre("Filtrar"));
        } else if (cu.getOpcion().equals("PBA")) {
            actor.attemptsTo(
                    WaitUntil.the(EGRESOS, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(EGRESOS, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(EGRESOS, isClickable()).forNoMoreThan(30).seconds(),
                    ClickEnEnlace.deNombre("Filtrar"));
        } else {
            System.out.println("Validar link Filtrar");
        }

        if (cu.getOpcion().equals("CA") || cu.getOpcion().equals("CC") || cu.getOpcion().equals("ADS") || cu.getOpcion().equals("AP") || cu.getOpcion().equals("PRE") || cu.getOpcion().equals("FDI") || cu.getOpcion().equals("EXT") || cu.getOpcion().equals("TDC")) {
            actor.attemptsTo(
                    Esperar.texto("Período de tiempo", 60),
                    SeleccionarEnCalendarioFechaLista.laFecha(datos),
                    ClickEnBoton.elElemento("BUSCAR MOVIMIENTOS"));
            Utilidades.esperar(5);
            actor.attemptsTo(
                    Esperar.pantallaDeCarga(),
                    Esperar.informacionLista(),
                    Ensure.that(MENSAJE_NO_MOVIMIENTOS).isNotDisplayed(),
                    Ensure.that(ELEMENTOS_TABLA_MOVIMIENTOS.resolveAllFor(actor).size()).isGreaterThan(0));
        } else if (cu.getOpcion().equals("PBA")) {
            actor.attemptsTo(
                    Esperar.texto("Rango de fechas", 60),
                    SeleccionarEnCalendarioFechaLista.laFecha(datos),
                    ClickEnBoton.elElemento("BUSCAR MOVIMIENTOS"));
            Utilidades.esperar(5);
            actor.attemptsTo(
                    WaitUntil.the(EGRESOS, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(EGRESOS, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(EGRESOS, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(EGRESOS),
                    Esperar.pantallaDeCarga(),
                    Esperar.informacionLista());
            System.out.println("Cantidad: " + ELEMENTOS_TABLA_MOVIMIENTOS.resolveAllFor(actor).size());
            actor.attemptsTo(
                    Ensure.that(MENSAJE_NO_MOVIMIENTOS).isNotDisplayed(),
                    Ensure.that(ELEMENTOS_TABLA_MOVIMIENTOS.resolveAllFor(actor).size()).isGreaterThan(0));

        } else {
            System.out.println("Validar link Filtrar");
        }
    }

    public static ValidacionMovimientoFecha para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidacionMovimientoFecha.class).withProperties(datos);
    }
}