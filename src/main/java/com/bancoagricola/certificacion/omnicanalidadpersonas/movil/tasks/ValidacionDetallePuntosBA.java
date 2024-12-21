package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Tarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TomarValores;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.ValoresDe;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionDetallePuntosBA implements Task {
    private final List<Tarjetas> datos2;
    private Map datosObtenidos;

    public ValidacionDetallePuntosBA(List<Tarjetas> datos2) {
        this.datos2 = datos2;
    }

    @Step("{0} realiza validación de detalle de 'Puntos BA'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Tarjetas tarj = datos2.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiTarjetas.menuTarjetas(), isVisible()).forNoMoreThan(20).seconds(),
                Click.on(UiTarjetas.menuTarjetas()),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(tarj.getAlias())).elementoVisibleEnElMedioDeLaPantalla(),
                Scroll.simple());

        actor.remember(PBA_ALIAS.toString(),tarj.getAlias());
        actor.remember(PBA_TIPO.toString(),TIPO.of(tarj.getAlias()).resolveFor(actor).getText());
        actor.remember(PBA_PUNTOS_ACUMULADOS.toString(),PUNTOS_ACUM.of(tarj.getAlias()).resolveFor(actor).getText());

        System.out.println("dato 1: " + actor.recall(PBA_ALIAS.toString()));
        System.out.println("dato 2: " + actor.recall(PBA_TIPO.toString()));
        System.out.println("dato 3: " + actor.recall(PBA_PUNTOS_ACUMULADOS.toString()));

        actor.attemptsTo(
                Click.on(UiGenerico.elementoQueContengaElTexto(tarj.getAlias())),
                Scroll.simple(),
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(20).seconds());

        System.out.println("dato 1: " + ALIAS.of(tarj.getAlias()).resolveFor(actor).getText());
        System.out.println("dato 2: " + PUNTOS_ACUM2.resolveFor(actor).getText());
        System.out.println("dato 3: " + SALDO_EN2.resolveFor(actor).getText());

        actor.attemptsTo(
                Ensure.that(ALIAS.of(tarj.getAlias()).resolveFor(actor).getText()).isEqualTo(actor.recall(PBA_ALIAS.toString())),
                Ensure.that(PUNTOS_ACUM2.resolveFor(actor).getText()).isEqualTo(actor.recall(PBA_PUNTOS_ACUMULADOS.toString())),
                Ensure.that(SALDO_EN2.resolveFor(actor).getText()).isNotEmpty());

        actor.remember(SALDOEN.toString(),SALDO_EN2.resolveFor(actor).getText().replace("$",""));

        actor.attemptsTo(
                Click.on(UiCuentas.linkMasDetalles()),
                WaitUntil.the(UiTarjetas.CONSULTA_PUNTOS, isVisible()).forNoMoreThan(5).seconds());

        actor.attemptsTo(
                Ensure.that(PUNTOS_ACUM2.resolveFor(actor).getText()).isEqualTo(actor.recall(PBA_PUNTOS_ACUMULADOS.toString())),
                Ensure.that(ACUE.resolveFor(actor).getText()).isEqualTo(actor.recall(PBA_ALIAS.toString())),
                Ensure.that(SALDO_EN2.resolveFor(actor).getText().replace("$","")).isEqualTo(actor.recall(SALDOEN.toString())),
                Ensure.that(PROXV.resolveFor(actor).getText()).isNotEmpty(),
                Ensure.that(TIPO2.resolveFor(actor).getText()).isNotEmpty());
    }

    public static ValidacionDetallePuntosBA para(List<Tarjetas> datos2) {
        return Instrumented.instanceOf(ValidacionDetallePuntosBA.class).withProperties(datos2);
    }
}
