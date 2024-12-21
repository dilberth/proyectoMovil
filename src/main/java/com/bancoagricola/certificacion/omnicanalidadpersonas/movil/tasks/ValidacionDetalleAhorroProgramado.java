package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Ahorros;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TomarValores;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.ValoresDe.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionDetalleAhorroProgramado implements Task {

    private final List<Ahorros> datos;

    public ValidacionDetalleAhorroProgramado(List<Ahorros> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza validación de detalle de 'Ahorro programado'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros ca = datos.get(0);

        boolean dato = true;

        actor.attemptsTo(
                WaitUntil.the(UiAhorros.menuMetas(), isVisible()).forNoMoreThan(30).seconds(),
                Click.on(UiAhorros.menuMetas()),
                Esperar.pantallaDeCarga());

        Utilidades.esperar(2);

        actor.attemptsTo(
                Scroll.hastaElElemento(UiAhorros.numeroDeCuenta(ca.getCuentaOrigen())));

        Map datosAhorro = TomarValores.delElemento(UiGenerico.informacionDe(ca.getCuentaOrigen()), elementosValoresAhorros);

        actor.remember(AP_ALIAS1.toString(), ca.getCuentaOrigen());
        actor.remember(AP_META1.toString(), datosAhorro.get("Meta"));
        actor.remember(AP_AHORRO_ACUMULADO1.toString(), datosAhorro.get("Ahorro acumulado"));
        actor.remember(AP_NUMERO_CUENTA1.toString(), datosAhorro.get("Nº"));

        actor.attemptsTo(
                Click.on(UiGenerico.elementoQueContengaElTexto(ca.getCuentaOrigen())),
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()),
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(30).seconds());

        datosAhorro = TomarValores.delElemento(UiGenerico.informacionDe(ca.getCuentaOrigen()), elementosValoresAhorrosVerMas);

        actor.attemptsTo(
                Ensure.that(UiCuentas.alias2Ca(TXTSUENO_REALIZADO_PROGRAMADO)).text().isEqualTo(actor.recall(AP_ALIAS1.toString())),
                Ensure.that(UiCuentas.tipoCuentaCa(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that((String) datosAhorro.get("Ahorro acumulado")).isEqualTo(actor.recall(AP_AHORRO_ACUMULADO1.toString()).toString()),
                Ensure.that((String) datosAhorro.get("Meta")).isEqualTo(actor.recall(AP_META1.toString()).toString()),
                Ensure.that((String) datosAhorro.get("Número")).isEqualTo(actor.recall(AP_NUMERO_CUENTA1.toString()).toString()),
                Ensure.that(UiGenerico.campoSelector(TXTFECHA_VENCIMIENTO)).isDisplayed());

        actor.remember(AP_TIPO_CUENTA2.toString(), UiCuentas.tipoCuentaCa(ca.getCuentaOrigen()).resolveFor(actor).getText());
        actor.remember(AP_FECHA_VENCIMIENTO2.toString(), datosAhorro.get("Fecha de vencimiento"));

        actor.attemptsTo(
                Click.on(UiCuentas.linkMasDetalles()),
                WaitUntil.the(UiGenerico.elementoDeTexto(TXTTIPOCUENTA), isVisible()).forNoMoreThan(20).seconds());

        datosAhorro = TomarValores.delElemento(UiGenerico.informacionDePantalla(), elementoValoresAhorrosDetalles);

        actor.attemptsTo(
                Ensure.that((String) datosAhorro.get("Alias de la cuenta")).isEqualTo(actor.recall(AP_ALIAS1.toString()).toString()),
                Ensure.that((String) datosAhorro.get("Tipo de cuenta")).isEqualTo(actor.recall(AP_TIPO_CUENTA2.toString()).toString()),
                Ensure.that((String) datosAhorro.get("Número de cuenta")).isEqualTo(actor.recall(AP_NUMERO_CUENTA1.toString()).toString()),
                Ensure.that(UiGenerico.campoSelector(TXTFECHA_CONTRATACION)).isDisplayed(),
                Ensure.that(UiGenerico.campoSelector(TXTCUOTA_MENSUAL)).isDisplayed(),
                Ensure.that(UiGenerico.campoSelector(TXTDIA_CARGO)).isDisplayed(),
                Scroll.hastaElElemento(UiGenerico.campoSelector(TXTAHORRO_ACUMULADO)));

        datosAhorro = TomarValores.delElemento(UiGenerico.informacionDePantalla(), elementoValoresAhorrosDetalles);

        actor.attemptsTo(
                Ensure.that(UiGenerico.campoSelector(TXTPLAZO_MESES)).isDisplayed(),
                Ensure.that((String) datosAhorro.get("Fecha de vencimiento")).isEqualTo(actor.recall(AP_FECHA_VENCIMIENTO2.toString()).toString()),
                Ensure.that((String) datosAhorro.get("Ahorro acumulado")).isEqualTo(actor.recall(AP_AHORRO_ACUMULADO1.toString()).toString()));
    }

    public static ValidacionDetalleAhorroProgramado con(List<Ahorros> datos) {
        return Instrumented.instanceOf(ValidacionDetalleAhorroProgramado.class).withProperties(datos);
    }
}
