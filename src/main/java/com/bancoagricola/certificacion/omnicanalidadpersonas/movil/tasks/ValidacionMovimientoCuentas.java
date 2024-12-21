package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
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

public class ValidacionMovimientoCuentas implements Task {
    private final List<Cuentas> datos;

    public ValidacionMovimientoCuentas(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida que se muestren los movimientos para la cuenta seleccionada")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(BANNER_BANCO_AGRICOLA));

        if (cu.getOpcion().equals("CA") || cu.getOpcion().equals("CC") || cu.getOpcion().equals("ADS")) {
            actor.attemptsTo(
                    WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(30).seconds());
        } else if (cu.getOpcion().equals("AP")) {
            actor.attemptsTo(
                    WaitUntil.the(MENU_METAS, isEnabled()).forNoMoreThan(30).seconds(),
                    Click.on(MENU_METAS));
        } else if (cu.getOpcion().equals("TDC")) {
            actor.attemptsTo(
                    WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(30).seconds(),
                    Click.on(MENU_TARJETAS));
        } else {
            System.out.println("Opción no válida");
        }

        actor.attemptsTo(
                Scroll.hastaElElemento(PRODUCTO(cu.getCuentaOrigen())).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(PRODUCTO(cu.getCuentaOrigen()), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PRODUCTO(cu.getCuentaOrigen()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PRODUCTO(cu.getCuentaOrigen()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(PRODUCTO(cu.getCuentaOrigen())),
                Scroll.hastaElElemento(VER_MAS).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(VER_MAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(VER_MAS),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(OPCION_MOVIMIENTOS).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(OPCION_MOVIMIENTOS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_MOVIMIENTOS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_MOVIMIENTOS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPCION_MOVIMIENTOS));

        if (cu.getOpcion().equals("CA") || cu.getOpcion().equals("CC") || cu.getOpcion().equals("ADS") || cu.getOpcion().equals("AP")) {
            actor.attemptsTo(
                    WaitUntil.the(MES_ACTUAL_FILTRAR, isEnabled()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(MES_ACTUAL_FILTRAR, isClickable()).forNoMoreThan(60).seconds(),
                    ClickEnEnlace.deNombre("Filtrar"));
        } else if (cu.getOpcion().equals("TDC")) {
            Utilidades.esperar(5);
            actor.attemptsTo(
                    ClickEnEnlace.deNombre("Filtrar"));
        } else {
            System.out.println("Validar link Filtrar");
        }

        actor.attemptsTo(
                Esperar.texto("Período de tiempo"),
                Click.on(OPCIONES(cu.getPeriodo())),
                ClickEnBoton.elElemento("BUSCAR MOVIMIENTOS"),
                Esperar.pantallaDeCarga(),
                Esperar.informacionLista());
        Utilidades.esperar(5);
        actor.attemptsTo(
                Ensure.that(MENSAJE_NO_MOVIMIENTOS).isNotDisplayed(),
                Ensure.that(ELEMENTOS_TABLA_MOVIMIENTOS.resolveAllFor(actor).size()).isGreaterThan(0));
        System.out.println("Movimientos: " + Utilidades.obtenerListaDeElementos(UiGenerico.listaDeInformacion("Movimientos")).size());
    }

    public static ValidacionMovimientoCuentas para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidacionMovimientoCuentas.class).withProperties(datos);
    }
}