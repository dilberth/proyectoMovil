package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaSaldosAhorroProgramadoDespues implements Task {
    private final List<Cuentas> datos;

    public ValidaSaldosAhorroProgramadoDespues(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' de 'ahorro programado' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_METAS, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(MENU_METAS, isClickable()).forNoMoreThan(10).seconds(),
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

        actor.remember(AHORRO_ACUMULADO_DESPUES.toString(), CAMPO_AHORRO_ACUMULADO.resolveFor(actor).getText().replace(",", "").replace("$", "").trim());
        System.out.println("Ahorro acumulado origen D: " + actor.recall(AHORRO_ACUMULADO_DESPUES.toString()));

        double saldoDestinoAnt = Double.parseDouble(actor.recall(AHORRO_ACUMULADO_ANTES.toString()));
        double saldoDestinoDes = Double.parseDouble(actor.recall(AHORRO_ACUMULADO_DESPUES.toString()));
        double valorAPagar1 = Double.parseDouble(cu.getMonto());
        double calculo1 = Math.round((saldoDestinoAnt - valorAPagar1) * 100.0) / 100.0;

        System.out.println("Esperado: "+calculo1);

        actor.attemptsTo(
                Ensure.that(saldoDestinoDes).isEqualTo(calculo1));
    }

    /*
        actor.attemptsTo(
                IrAProducto.ahorros(aho.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.MAS_DETALLE.tomarTransaccion()),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTALIAS_CUENTA), isVisible()).forNoMoreThan(20).seconds(),
                VerEnPantalla.elTexto(TXTAHORRO_ACUMULADO)
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.elementoValoresAhorrosDetalles);

        double saldoCuentaDesD = Double.parseDouble(((String) datosObtenidos.get(TXTAHORRO_ACUMULADO)).replace(",", "").replace("$", "").trim());
        double saldoCuentaAntD = Double.parseDouble(actor.recall(AHORRO_ACUMULADO.toString()).toString());
        double valorAPagar = Double.parseDouble(aho.getMonto());
        double calculo = Math.round((saldoCuentaAntD - valorAPagar) * 100.0) / 100.0;

        actor.attemptsTo(
                Ensure.that(saldoCuentaDesD).isEqualTo(calculo),
                VolverInicio.click()
        );

    }

     */

    public static ValidaSaldosAhorroProgramadoDespues para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosAhorroProgramadoDespues.class).withProperties(datos);
    }
}
