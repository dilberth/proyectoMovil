package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
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

public class ValidaSaldosTarjetaCreditoDespues implements Task {

    private final List<Cuentas> datos;
    //private Map datosObtenidos;

    public ValidaSaldosTarjetaCreditoDespues(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' de 'tarjeta de credito' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MENU_TARJETAS),
                Esperar.pantallaDeCarga(),
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

        System.out.println("Esperado: "+calculo2);

        actor.attemptsTo(
                Ensure.that(saldoOrigenDes).isEqualTo(calculo2));
    }

    /*
        actor.attemptsTo(
                IrAProducto.tarjeta(tarj.getTarjetaCredito()).ySeleccionarLaTransaccion(TransaccionesTarjetas.MAS_DETALLE.toString()),
                WaitUntil.the(UiGenerico.campoSelector(TXTSALDO_DISPONIBLE), isVisible()).forNoMoreThan(20).seconds()
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.tarjetaDeCreditoMasDetalle);

        double saldoCuentaDesD = Double.parseDouble(((String) datosObtenidos.get(TXTSALDO_DISPONIBLE)).replace(",", "").replace("$", "").trim());
        double saldoCuentaAntD = Double.parseDouble(actor.recall(SALDO_TARJETACREDITO.toString()).toString());
        double valorAPagar = Double.parseDouble(tarj.getMonto());
        double calculo = Math.round((saldoCuentaAntD - valorAPagar) * 100.0) / 100.0;

        actor.attemptsTo(
                Ensure.that(saldoCuentaDesD).isEqualTo(calculo),
                VolverInicio.click()
        );

     */

    public static ValidaSaldosTarjetaCreditoDespues para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosTarjetaCreditoDespues.class).withProperties(datos);
    }
}
