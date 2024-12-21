package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.CantidadRegistrosCompasPlazo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.CantidadRegistrosFondosReservados;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.MAS_DETALLE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas.MENU_TARJETAS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas.OPCION_MOVIMIENTOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class ValidacionDiferidosTDC implements Task {
    private final List<Cuentas> tarjeta;

    public ValidacionDiferidosTDC(List<Cuentas> tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Step("{0} realiza validación de diferidos de 'Tarjeta de crédito'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas tarj = tarjeta.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MENU_TARJETAS),
                Esperar.pantallaDeCarga());

        if (VER_MAS_TARJ.resolveFor(actor).isVisible()) {
            System.out.println("Se muestra el link 'Ver más tarjetas'");
            actor.attemptsTo(
                    Click.on(VER_MAS_TARJ),
                    Esperar.pantallaDeCarga());
            if (VER_MAS_TARJ.resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        Click.on(VER_MAS_TARJ),
                        Esperar.pantallaDeCarga());
            } else if (VER_MAS_TARJ.resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        Click.on(VER_MAS_TARJ),
                        Esperar.pantallaDeCarga());
            }
        } else {
            System.out.println("No se encuentra link 'Ver más tarjetas'");
        }

        actor.attemptsTo(
                Scroll.hastaElElemento(PRODUCTO(tarj.getTarjetaCredito())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(PRODUCTO(tarj.getTarjetaCredito())),
                Scroll.hastaElElemento(VER_MAS).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(VER_MAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(VER_MAS),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isClickable()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(OPCION_MOVIMIENTOS),
                WaitUntil.the(OPCION_MOVIMIENTOS, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(OPCION_MOVIMIENTOS),
                WaitUntil.the(OPCION_OTROS, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(OPCION_OTROS, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(OPCION_OTROS),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto("Compras a plazo"), isVisible()).forNoMoreThan(45).seconds(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto("Fondos reservados"), isVisible()).forNoMoreThan(45).seconds());

        if (OTROS.of("Compras a plazo").resolveAllFor(actor).size() >= 1) {
            System.out.println("Cantidad de Compras a plazo: " + OTROS.of("Compras a plazo").resolveAllFor(actor).size());
            actor.should(seeThat(CantidadRegistrosCompasPlazo.tiene(), greaterThanOrEqualTo(1)).because(actor + "valida que la cantidad de registros sea mayor o igual a 1"));
        } else {
            System.out.println("Cantidad de Fondos reservados: " + OTROS.of("Fondos reservados").resolveAllFor(actor).size());
            actor.should(seeThat(CantidadRegistrosFondosReservados.tiene(), greaterThanOrEqualTo(1)).because(actor + "valida que la cantidad de registros sea mayor o igual a 1"));
        }
    }

    public static ValidacionDiferidosTDC para(List<Cuentas> tarjeta) {
        return Instrumented.instanceOf(ValidacionDiferidosTDC.class).withProperties(tarjeta);
    }
}