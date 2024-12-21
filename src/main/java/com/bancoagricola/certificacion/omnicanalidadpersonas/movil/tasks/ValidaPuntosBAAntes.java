package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaPuntosBAAntes implements Task {
    private final List<Cuentas> datos;

    public ValidaPuntosBAAntes(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Puntos BA' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MENU_TARJETAS),
                Esperar.pantallaDeCarga(),
                Scroll.hastaElElemento(PRODUCTO(cu.getAlias())).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(PRODUCTO(cu.getAlias()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PRODUCTO(cu.getAlias()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(PRODUCTO(cu.getAlias())),
                Scroll.simple(),
                WaitUntil.the(VER_MAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(VER_MAS),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MAS_DETALLE),
                WaitUntil.the(PUNTOS_ACUMULADOS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PUNTOS_ACUMULADOS, isEnabled()).forNoMoreThan(30).seconds());

        actor.remember(SALDO_PUNTOS_ANTES.toString(), PUNTOS_ACUMULADOS.resolveFor(actor).getText().replace(",", "").replace("$", "").trim());
        System.out.println("Saldo puntosBA A: " + actor.recall(SALDO_PUNTOS_ANTES.toString()));

    }

    public static ValidaPuntosBAAntes para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaPuntosBAAntes.class).withProperties(datos);
    }
}