package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VerMasCuentasOrig;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.SALDO_RETENIDO;

public class ValidaSaldosRetenidoDespues implements Task {
    private final List<Cuentas> datos;

    public ValidaSaldosRetenidoDespues(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo retenido' para la cuenta despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                VerMasCuentasOrig.para(datos));

        double saldoCuentaDesD = Double.parseDouble(UiCuentas.saldoRetenido().resolveFor(actor).getAttribute("text").replace(",", "").replace("$", "").trim());
        double saldoCuentaAntD = Double.parseDouble(actor.recall(SALDO_RETENIDO.toString()).toString().replace(",", "").replace("$", "").trim());
        double valorAPagar = Double.parseDouble(cu.getMonto());
        double calculo = Math.round((saldoCuentaAntD + valorAPagar) * 100.0) / 100.0;
        System.out.println("Saldo retenido despues: " + saldoCuentaDesD);
        System.out.println("Calculo: " + calculo);
        actor.attemptsTo(
                Ensure.that(saldoCuentaDesD).isEqualTo(calculo));
    }

    public static ValidaSaldosRetenidoDespues para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosRetenidoDespues.class).withProperties(datos);
    }
}