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

import java.util.List;
import java.util.Map;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionDetalleCuentaAhorro implements Task {

    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ValidacionDetalleCuentaAhorro(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza validación de detalle de 'Cuenta de ahorros'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds(),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getCuentaOrigen())).elementoVisibleEnElMedioDeLaPantalla());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDe(cu.getCuentaOrigen()), ValoresDe.valoresCuentas);

        actor.remember(CA_ALIAS1.toString(), UiCuentas.aliasCa(cu.getCuentaOrigen()).resolveFor(actor).getText());
        actor.remember(Variables.CA_TIPO_CUENTA1.toString(), datosObtenidos.get(TITULO_AHORRO));
        actor.remember(Variables.CA_SALDO1.toString(), datosObtenidos.get(TXTSALDO_DISPONIBLE));
        actor.remember(Variables.CA_NUMERO_CUENTA.toString(), datosObtenidos.get(NUMERO_A));

        actor.attemptsTo(
                Click.on(UiGenerico.elementoQueContengaElTexto(cu.getCuentaOrigen())),
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(40).seconds());

        actor.attemptsTo(
                Ensure.that(TIPO.of(cu.getCuentaOrigen()).resolveFor(actor).getText()).isEqualTo(actor.recall(CA_TIPO_CUENTA1.toString())),
                Ensure.that(VARIABLE.of("Saldo disponible").resolveFor(actor).getText()).isEqualTo(actor.recall(CA_SALDO1.toString())),
                Ensure.that(VARIABLE.of("Saldo Retenido").resolveFor(actor).getText()).isNotEmpty(),
                Ensure.that(VARIABLE2.of("Más detalle").resolveFor(actor).getText().replace("Nº","")).isEqualTo(actor.recall(CA_NUMERO_CUENTA.toString())));

        actor.remember(NUM_CUEN3.toString(), VARIABLE2.of("Más detalle").resolveFor(actor).getText().replace("Nº",""));

        actor.attemptsTo(
                Click.on(UiCuentas.linkMasDetalles()),
                WaitUntil.the(UiGenerico.campoSelector(TXTSALDO_DISPONIBLE), isVisible()).forNoMoreThan(20).seconds());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresCuentaDeAhorrosMasDetalle);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTALIAS_CUENTA)).isEqualTo(cu.getCuentaOrigen()),
                Ensure.that((String) datosObtenidos.get(TXTTIPOCUENTA)).isEqualTo(actor.recall(CA_TIPO_CUENTA1.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTNUMERO_CUENTA)).isEqualTo(actor.recall(NUM_CUEN3.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTSALDO_DISPONIBLE)).isEqualTo(actor.recall(CA_SALDO1.toString()).toString()));
    }

    public static ValidacionDetalleCuentaAhorro con(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidacionDetalleCuentaAhorro.class).withProperties(datos);
    }
}
