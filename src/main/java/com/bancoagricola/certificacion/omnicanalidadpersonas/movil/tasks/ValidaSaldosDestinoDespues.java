package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaSaldosDestinoDespues implements Task {
    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ValidaSaldosDestinoDespues(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' para cuenta 'Destino' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(30).seconds(),
                Esperar.pantallaDeCarga(),
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

        actor.remember(SALDO_ORIGEN_ANTES.toString(), SALDO_DISPONIBLE.resolveFor(actor).getText().replace(",", "").replace("$", "").trim());
        System.out.println("Saldo origen A: " + actor.recall(SALDO_ORIGEN_ANTES.toString()));

        /*
        actor.attemptsTo(
                IrAProducto.cuenta(cu.getCuentaDestino()).ySeleccionarLaTransaccion(TransaccionesCuentas.MAS_DETALLE.tomarTransaccion()),
                WaitUntil.the(UiGenerico.campoSelector(TXTSALDO_DISPONIBLE), isVisible()).forNoMoreThan(20).seconds()
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(),ValoresDe.valoresCuentaDeAhorrosMasDetalle);

        double saldoCuentaDesD = Double.parseDouble(((String)datosObtenidos.get(TXTSALDO_DISPONIBLE)).replace(",", "").replace("$", "").trim());
        double saldoCuentaAntD = Double.parseDouble(actor.recall(SALDO_CTADESINI.toString()).toString().replace(",", "").replace("$", "").trim());
        double valorAPagar = Double.parseDouble(cu.getMonto());
        double calculo = Math.round((saldoCuentaAntD + valorAPagar) * 100.0) / 100.0;
        actor.attemptsTo(
                Ensure.that(saldoCuentaDesD).isEqualTo(calculo)
        );
        */
    }

    public static ValidaSaldosDestinoDespues para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosDestinoDespues.class).withProperties(datos);
    }
}
