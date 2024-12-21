package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
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

public class ValidaSaldosOrigenDespuesMOD1 implements Task {
    private final List<Cuentas> datos;

    public ValidaSaldosOrigenDespuesMOD1(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' para cuenta 'Origen' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(PRODUCTO(cu.getCuentaOrigen())).elementoVisibleEnElMedioDeLaPantalla(),
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
                WaitUntil.the(LABEL_SALDO_DISPONIBLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LABEL_SALDO_DISPONIBLE, isEnabled()).forNoMoreThan(30).seconds());

        actor.remember(SALDO_ORIGEN_DESPUES.toString(), SALDO_DISPONIBLE.resolveFor(actor).getText().replace(",", "").replace("$", "").trim());
        System.out.println("Saldo origen D: " + actor.recall(SALDO_ORIGEN_DESPUES.toString()));

        double saldoOrigenAnt = Double.parseDouble(actor.recall(SALDO_ORIGEN_ANTES.toString()));
        double saldoOrigenDes = Double.parseDouble(actor.recall(SALDO_ORIGEN_DESPUES.toString()));
        double valorAPagar2 = Double.parseDouble(cu.getMonto());
        double calculo2 = Math.round((saldoOrigenAnt - valorAPagar2) * 100.0) / 100.0;

        System.out.println("Calculo origen: "+calculo2);

        actor.attemptsTo(
                Ensure.that(saldoOrigenDes).isEqualTo(calculo2));
    }

    public static ValidaSaldosOrigenDespuesMOD1 para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosOrigenDespuesMOD1.class).withProperties(datos);
    }
}
