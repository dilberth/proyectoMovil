package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaSaldosAhorroProgramadoAntes implements Task {
    private final List<Cuentas> datos;

    public ValidaSaldosAhorroProgramadoAntes(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' de 'Ahorro programado' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_METAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_METAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MENU_METAS),
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
                WaitUntil.the(MAS_DETALLE, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MAS_DETALLE),
                WaitUntil.the(LABEL_AHORRO_ACUMULADO, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LABEL_AHORRO_ACUMULADO, isEnabled()).forNoMoreThan(30).seconds());

        actor.remember(AHORRO_ACUMULADO_ANTES.toString(), CAMPO_AHORRO_ACUMULADO.resolveFor(actor).getText().replace(",", "").replace("$", "").trim());
        System.out.println("Ahorro acumulado origen A: " + actor.recall(AHORRO_ACUMULADO_ANTES.toString()));

    }

    public static ValidaSaldosAhorroProgramadoAntes para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosAhorroProgramadoAntes.class).withProperties(datos);
    }
}
