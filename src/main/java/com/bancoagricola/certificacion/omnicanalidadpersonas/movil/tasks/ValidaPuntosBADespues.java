package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ValidaPuntosBADespues implements Task {
    private final List<Cuentas> datos2;

    public ValidaPuntosBADespues(List<Cuentas> datos2) { this.datos2 = datos2;
    }

    @Step("{0} valida 'Puntos BA acumulados' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos2.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(30).seconds(),
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

        actor.remember(SALDO_PUNTOS_DESPUES.toString(), PUNTOS_ACUMULADOS.resolveFor(actor).getText().replace(",", "").replace("$", "").trim());
        System.out.println("Saldo PuntosBA D: " + actor.recall(SALDO_PUNTOS_DESPUES.toString()));

        double saldoOrigenAnt = Double.parseDouble(actor.recall(SALDO_PUNTOS_ANTES.toString()));
        double saldoOrigenDes = Double.parseDouble(actor.recall(SALDO_PUNTOS_DESPUES.toString()));
        double valorAPagar2 = Double.parseDouble(cu.getPuntos());
        double calculo2 = Math.round((saldoOrigenAnt - valorAPagar2) * 100.0) / 100.0;

        System.out.println("Calculo PuntosBA: "+calculo2);

        actor.attemptsTo(
                Ensure.that(saldoOrigenDes).isEqualTo(calculo2));
    }

    public static ValidaPuntosBADespues para(List<Cuentas> datos2) {
        return Instrumented.instanceOf(ValidaPuntosBADespues.class).withProperties(datos2);
    }
}