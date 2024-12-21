package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TomarValores;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.ValoresDe;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.reports.json.gson.GsonPreviousOutcomeConverter;

import java.util.List;
import java.util.Map;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionDetalleDAP implements Task {

    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ValidacionDetalleDAP(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza validación de detalle de 'Deposito a plazo'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds(),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getCuentaOrigen())).elementoVisibleEnElMedioDeLaPantalla().tiempoMaximoScroll(120)
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDe(cu.getCuentaOrigen()), ValoresDe.valoresCuentasDepositoPlazos);

        actor.remember(CA_ALIAS1.toString(), cu.getCuentaOrigen());
        actor.remember(Variables.CA_TIPO_CUENTA1.toString(), datosObtenidos.get(TITULO_AHORRO));
        actor.remember(Variables.CA_SALDO1.toString(), datosObtenidos.get(TXTSALDO_DISPONIBLE));
        actor.remember(Variables.CA_NUMERO_CUENTA.toString(), datosObtenidos.get(NUMERO_A));

        actor.attemptsTo(
                Click.on(UiGenerico.elementoQueContengaElTexto(cu.getCuentaOrigen())),
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(20).seconds());

        actor.attemptsTo(
                Ensure.that(VARIABLE.of("Depósito a plazo digital").resolveFor(actor).getText()).isEqualTo(actor.recall(CA_ALIAS1.toString())),
                Ensure.that(VARIABLE.of("Saldo principal").resolveFor(actor).getText()).isEqualTo(actor.recall(CA_SALDO1.toString())),
              //  Ensure.that(VARIABLE3.of("Nº").resolveFor(actor).getText()).isEqualTo(actor.recall(CA_NUMERO_CUENTA.toString())),
                Ensure.that(VARIABLE.of("Fecha de vencimiento").resolveFor(actor).getText()).isNotEmpty());

        actor.remember(DAP_SALDO_PRINCIPAL.toString(), VARIABLE.of("Saldo principal").resolveFor(actor).getText());
      //  actor.remember(DAP_NUMERO_CUENTA2.toString(), VARIABLE3.of("Nº").resolveFor(actor).getText());
        actor.remember(DAP_FECHA_VENCIMIENTO2.toString(), VARIABLE.of("Fecha de vencimiento").resolveFor(actor).getText());

        actor.attemptsTo(
                Click.on(UiCuentas.linkMasDetalles()),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTALIAS_CUENTA), isVisible()).forNoMoreThan(20).seconds());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresCuentasDepositoPlazosMasDetalles);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTALIAS_CUENTA)).isEqualTo(actor.recall(CA_ALIAS1.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTTIPOCUENTA)).isEqualTo(actor.recall(CA_TIPO_CUENTA1.toString()).toString()),
               // Ensure.that((String) datosObtenidos.get(TXTNUMERO_CUENTA)).isEqualTo(actor.recall(DAP_NUMERO_CUENTA2.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTSALDO_PRINCIPAL)).isEqualTo(actor.recall(DAP_SALDO_PRINCIPAL.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTFECHA_DE_VENCIMIENTO)).isEqualTo(actor.recall(DAP_FECHA_VENCIMIENTO2.toString()).toString()),
                Scroll.hastaElElemento(UiGenerico.campoSelector(TXTTASA_INTERES)));

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresCuentasDepositoPlazosMasDetalles);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTULTIMO_PAGO)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTMONTO_INICIAL)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTTASA_INTERES)).isNotEmpty());

    }

    public static ValidacionDetalleDAP con(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidacionDetalleDAP.class).withProperties(datos);
    }
}