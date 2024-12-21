package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Ahorros;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidadorEliminarMeta implements Task {
    private final List<Ahorros> meta;

    public ValidadorEliminarMeta(List<Ahorros> meta) {
        this.meta = meta;
    }

    @Step("{0} 'Valida si existe meta y la elimina'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros aho = meta.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds(),
                ClickEn.elElemento(UiCuentas.menuCuentas()),
                ClickEn.elElemento(UiAhorros.menuMetas()));


        if (UiGenerico.elementoQueContengaElTexto(aho.getNombreMeta()).resolveAllFor(actor).size() <= 0) {
            Scroll.simple().performAs(actor);
        } else {
            actor.attemptsTo(
                    WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds());
        }

        if (UiGenerico.elementoQueContengaElTexto(aho.getNombreMeta()).resolveAllFor(actor).size() <= 0) {
            Scroll.simple().performAs(actor);
        } else {
            actor.attemptsTo(
                    WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds());
        }

        if (UiGenerico.elementoQueContengaElTexto(aho.getNombreMeta()).resolveAllFor(actor).size() > 0) {
            actor.attemptsTo(
                    Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(aho.getNombreMeta())).elementoVisibleEnElMedioDeLaPantalla(),
                    ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(aho.getNombreMeta())),
                    Scroll.hastaElElemento(UiCuentas.opcionVerMas()).elementoVisibleEnElMedioDeLaPantalla(),
                    ClickEn.elElemento(UiCuentas.opcionVerMas()),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMONTO_ACUMULADO), isVisible()).forNoMoreThan(20).seconds(),
                    ClickEn.elElemento(UiAhorros.linkEliminar()),
                    ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTBTN_ACEPTAR)),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF12), isVisible()).forNoMoreThan(60).seconds(),
                    VolverInicio.click());
        } else {
            actor.attemptsTo(
                    WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds());
        }

    }


    public static ValidadorEliminarMeta con(List<Ahorros> meta) {
        return Instrumented.instanceOf(ValidadorEliminarMeta.class).withProperties(meta);
    }
}