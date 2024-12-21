package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.ScrollVertical;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTSALDO_DISPONIBLE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.SALDO_CTAORGINI;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidaSaldosOrigenDespues2 implements Task {
    private final List<Cuentas> datos;

    public ValidaSaldosOrigenDespues2(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' para cuenta 'Origen' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(30).seconds(),
                Click.on(UiCuentas.menuCuentas()),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getCuentaOrigen())),
                Click.on(UiGenerico.elementoQueContengaElTexto(cu.getCuentaOrigen())),
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()));
        ScrollVertical.corto().ejecutar();
        actor.attemptsTo(
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(30).seconds(),
                Click.on(UiCuentas.linkMasDetalles()),
                WaitUntil.the(UiGenerico.campoSelector(TXTSALDO_DISPONIBLE), isVisible()).forNoMoreThan(30).seconds());

        double saldoCuentaDesD = Double.parseDouble(UiGenerico.campoSelector(TXTSALDO_DISPONIBLE).resolveFor(actor).getAttribute("text").replace(",", "").replace("$", "").trim());
        double saldoCuentaAntD = Double.parseDouble(actor.recall(SALDO_CTAORGINI.toString()).toString());
        double valorAPagar = Double.parseDouble(cu.getMonto());
        double calculo = Math.round((saldoCuentaAntD - valorAPagar) * 100.0) / 100.0;
        System.out.println("Saldo origen despues: " + saldoCuentaDesD);
        System.out.println("Calculo: " + calculo);
        actor.attemptsTo(
                Ensure.that(saldoCuentaDesD).isEqualTo(calculo));
    }

    public static ValidaSaldosOrigenDespues2 para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosOrigenDespues2.class).withProperties(datos);
    }
}
