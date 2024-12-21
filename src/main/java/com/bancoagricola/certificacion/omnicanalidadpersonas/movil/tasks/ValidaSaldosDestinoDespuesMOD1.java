package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaSaldosDestinoDespuesMOD1 implements Task {
    private final List<Cuentas> datos;

    public ValidaSaldosDestinoDespuesMOD1(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' para cuenta 'Destino' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(MENU_CUENTAS),
                Scroll.hastaElElemento(PRODUCTO(cu.getCuentaDestino())).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(PRODUCTO(cu.getCuentaDestino()), isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(PRODUCTO(cu.getCuentaDestino()), isClickable()).forNoMoreThan(10).seconds(),
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

        actor.remember(SALDO_DESTINO_DESPUES.toString(), SALDO_DISPONIBLE.resolveFor(actor).getText().replace(",", "").replace("$", "").trim());
        System.out.println("Saldo destino D: " + actor.recall(SALDO_DESTINO_DESPUES.toString()));

        double saldoDestinoAnt = Double.parseDouble(actor.recall(SALDO_DESTINO_ANTES.toString()));
        double saldoDestinoDes = Double.parseDouble(actor.recall(SALDO_DESTINO_DESPUES.toString()));
        double valorAPagar1 = Double.parseDouble(cu.getMonto());
        double calculo1 = Math.round((saldoDestinoAnt + valorAPagar1) * 100.0) / 100.0;

        System.out.println("Esperado: "+calculo1);

        actor.attemptsTo(
                Ensure.that(saldoDestinoDes).isEqualTo(calculo1));
    }

    public static ValidaSaldosDestinoDespuesMOD1 para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosDestinoDespuesMOD1.class).withProperties(datos);
    }
}
