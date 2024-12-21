package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaSaldosDestinoAntesMOD1 implements Task {
    private final List<Cuentas> datos;

    public ValidaSaldosDestinoAntesMOD1(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' para cuenta 'Destino' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(PRODUCTO(cu.getCuentaDestino())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(PRODUCTO(cu.getCuentaDestino())),
                Scroll.hastaElElemento(VER_MAS).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(VER_MAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(VER_MAS),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MAS_DETALLE),
                WaitUntil.the(LABEL_SALDO_DISPONIBLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LABEL_SALDO_DISPONIBLE, isEnabled()).forNoMoreThan(30).seconds());

        actor.remember(SALDO_DESTINO_ANTES.toString(), SALDO_DISPONIBLE.resolveFor(actor).getText().replace(",", "").replace("$", "").trim());
        System.out.println("Saldo destino A: " + actor.recall(SALDO_DESTINO_ANTES.toString()));
    }

    public static ValidaSaldosDestinoAntesMOD1 para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosDestinoAntesMOD1.class).withProperties(datos);
    }
}
