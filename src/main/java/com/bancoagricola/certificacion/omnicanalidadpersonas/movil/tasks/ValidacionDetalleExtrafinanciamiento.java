package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TomarValores;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.ValoresDe;
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

public class ValidacionDetalleExtrafinanciamiento implements Task {

    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ValidacionDetalleExtrafinanciamiento(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza validación de detalle de 'Extrafinanciamiento'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds(),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getReferencia())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(UiGenerico.elementoQueContengaElTexto(cu.getReferencia())),
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()).elementoVisibleEnElMedioDeLaPantalla());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDe(cu.getReferencia()), ValoresDe.valoresPrestamo);

        actor.remember(CA_ALIAS1.toString(), cu.getReferencia());
        actor.remember(CA_TIPO_CUENTA1.toString(), datosObtenidos.get(TITULO_AHORRO));
        actor.remember(EF_DEUDA_TOTAL.toString(), datosObtenidos.get(TXTDEUDA_TOTAL));
        actor.remember(CA_NUMERO_CUENTA.toString(), datosObtenidos.get(NUMERO_A));
        actor.remember(EF_FECHA_PAGO.toString(), datosObtenidos.get(TXTFECHA_DE_PAGO));

        actor.attemptsTo(
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(20).seconds());

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TITULO_AHORRO)).isEqualTo(actor.recall(CA_TIPO_CUENTA1.toString())),
                Ensure.that((String) datosObtenidos.get(TXTDEUDA_TOTAL)).isEqualTo(actor.recall(EF_DEUDA_TOTAL.toString())),
                Ensure.that((String) datosObtenidos.get(NUMERO_A)).isEqualTo(actor.recall(CA_NUMERO_CUENTA.toString())),
                Ensure.that((String) datosObtenidos.get(TXTFECHA_DE_PAGO)).isEqualTo(actor.recall(EF_FECHA_PAGO.toString())));

        actor.remember(EF_DEUDA_TOTAL2.toString(), datosObtenidos.get(TXTDEUDA_TOTAL));
        actor.remember(EF_NUMERO_CUENTA2.toString(), datosObtenidos.get(NUMERO_A));

        actor.attemptsTo(
                Click.on(UiCuentas.linkMasDetalles()),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTALIAS_O_REFERENCIA), isVisible()).forNoMoreThan(20).seconds());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresPrestamoMasDetalle);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTALIAS_O_REFERENCIA)).isEqualTo(actor.recall(CA_ALIAS1.toString())),
                Ensure.that((String) datosObtenidos.get(TXTTIPO)).isEqualTo(actor.recall(CA_TIPO_CUENTA1.toString())),
                Ensure.that((String) datosObtenidos.get(TXTNUMERO)).isEqualTo(actor.recall(EF_NUMERO_CUENTA2.toString())),
                Ensure.that((String) datosObtenidos.get(TXTMONTO_ORIGINAL)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTDEUDA_TOTAL)).isEqualTo(actor.recall(EF_DEUDA_TOTAL2.toString())),
                Scroll.hastaElElemento(UiGenerico.campoSelector(TXTFECHA_DE_PAGO)));

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresPrestamoMasDetalle);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTCUOTA)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTTASA_INTERES)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTFECHA_DE_PAGO)).isEqualTo(actor.recall(EF_FECHA_PAGO.toString())),
                Ensure.that((String) datosObtenidos.get(TXTVALOR_PENDIENTE_PAGO)).isNotEmpty(),
                Scroll.hastaElElemento(UiGenerico.campoSelector(TXTDIAS_EN_MORA)));

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresPrestamoMasDetalle);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTCUOTAS_EN_MORA)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTDIAS_EN_MORA)).isNotEmpty());
    }

    public static ValidacionDetalleExtrafinanciamiento con(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidacionDetalleExtrafinanciamiento.class).withProperties(datos);
    }

}