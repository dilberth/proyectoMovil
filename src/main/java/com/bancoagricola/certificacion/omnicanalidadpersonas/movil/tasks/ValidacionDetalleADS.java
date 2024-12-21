package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.VARIABLE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.VARIABLE2;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidacionDetalleADS implements Task {

    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ValidacionDetalleADS(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza validación de detalle de 'Adelanto de salario'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds(),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getAds())).elementoVisibleEnElMedioDeLaPantalla());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDe(cu.getAds()), ValoresDe.valoresCuentas);

        actor.remember(CA_ALIAS1.toString(), cu.getAds());
        actor.remember(Variables.CA_TIPO_CUENTA1.toString(), datosObtenidos.get(TITULO_AHORRO));
        actor.remember(Variables.CA_SALDO1.toString(), datosObtenidos.get(TXTSALDO_DISPONIBLE));
        actor.remember(Variables.CA_NUMERO_CUENTA.toString(), datosObtenidos.get(NUMERO_A));
        actor.remember(Variables.CA_NUMERO_CUENTA1.toString(), VARIABLE.of(cu.getAds()).resolveFor(actor).getText());

        actor.attemptsTo(
                Click.on(UiGenerico.elementoQueContengaElTexto(cu.getAds())),
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()),
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(20).seconds());

        actor.attemptsTo(
                Ensure.that(VARIABLE.of("Adelanto Salarial").resolveFor(actor).getText()).isEqualTo(cu.getAds()),
                Ensure.that(VARIABLE.of("Monto disponible").resolveFor(actor).getText()).isEqualTo(actor.recall(CA_SALDO1.toString())),
                Ensure.that(VARIABLE.of("Saldo Retenido").resolveFor(actor).getText()).isNotEmpty(),
                Ensure.that(VARIABLE2.of("Más detalle").resolveFor(actor).getText().replace("Nº","")).isEqualTo(actor.recall(CA_NUMERO_CUENTA.toString().replace("Nº",""))));

        actor.remember(CA_NUMERO_CUENTAP2.toString(), VARIABLE2.of("Más detalle").resolveFor(actor).getText().replace("Nº",""));

        actor.attemptsTo(
                Click.on(UiCuentas.linkMasDetalles()),
                WaitUntil.the(UiGenerico.elementoDeTexto(TXTALIAS_CUENTA), isVisible()).forNoMoreThan(30).seconds());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresCuentaDeCorrienteAdelantoSalarialMasDetalle);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTALIAS_CUENTA)).isEqualTo(actor.recall(CA_ALIAS1.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTTIPOCUENTA)).isEqualTo(actor.recall(CA_TIPO_CUENTA1.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTNUMERO_CUENTA)).isEqualTo(actor.recall(CA_NUMERO_CUENTAP2.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTMONTO_APROBADO)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTMONTO_UTILIZADO)).isNotEmpty(),
                WaitUntil.the(UiGenerico.campoSelector(TXTPORCENTAJE), isVisible()).forNoMoreThan(5).seconds(),
                Scroll.hastaElElemento(UiGenerico.campoSelector(TXTPORCENTAJE)));

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresCuentaDeCorrienteAdelantoSalarialMasDetalle);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTMONTO_DISPONIBLE)).isEqualTo(actor.recall(CA_SALDO1.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTMONTO_A_PAGAR)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTPORCENTAJE)).isNotEmpty());
    }

    public static ValidacionDetalleADS con(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidacionDetalleADS.class).withProperties(datos);
    }
}
