package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Tarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TomarValores;
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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionDetalleTDC implements Task {
    private final List<Tarjetas> tarjeta;
    private Map datosObtenidos;

    public ValidacionDetalleTDC(List<Tarjetas> tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Step("{0} realiza validación de detalle de 'Tarjeta de crédito'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Tarjetas tarj = tarjeta.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiTarjetas.menuTarjetas(), isVisible()).forNoMoreThan(20).seconds(),
                Click.on(UiTarjetas.menuTarjetas()),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(tarj.getTarjetaCredito())).elementoVisibleEnElMedioDeLaPantalla()
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDe(tarj.getTarjetaCredito()), ValoresDe.tarjetaDeCredito);

        actor.remember(TDC_ALIAS.toString(), tarj.getTarjetaCredito());
        actor.remember(TDC_PRODUCTO.toString(), UiGenerico.campoSelector3(tarj.getTarjetaCredito()).resolveFor(actor).getText());
        actor.remember(TDC_SALDO_DISPONIBLE.toString(), datosObtenidos.get(TXTSALDO_DISPONIBLE));
        actor.remember(TDC_TIPO.toString(), datosObtenidos.get(TXTTIPO));
        actor.remember(TDC_FECHA_PAGO.toString(), datosObtenidos.get(TXTFECHA_DE_PAGO));

        actor.attemptsTo(
                Click.on(UiGenerico.elementoQueContengaElTexto(tarj.getTarjetaCredito())),
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()),
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(30).seconds()
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.tarjetaDeCreditoVerMas);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTTARJETA_CREDITO)).contains((String)actor.recall(TDC_PRODUCTO.toString())),
                Ensure.that((String) datosObtenidos.get(TXTTIPO)).isEqualTo(actor.recall(TDC_TIPO.toString())),
                Ensure.that((String) datosObtenidos.get(TXTSALDO_DISPONIBLE)).isEqualTo(actor.recall(TDC_SALDO_DISPONIBLE.toString())),
                Ensure.that((String) datosObtenidos.get(TXTFECHA_DE_PAGO)).isEqualTo(actor.recall(TDC_FECHA_PAGO.toString())),
                Ensure.that((String) datosObtenidos.get(TXTSALDO_A_PAGAR)).isNotEmpty()
        );

        actor.remember(TDC_SALDO_A_PAGAR.toString(), datosObtenidos.get(TXTSALDO_A_PAGAR));
        actor.remember(TDC_NUMERO2.toString(), "**** **** " + UiGenerico.campoSelector3(TXTMAS_DETALLE).resolveFor(actor).getText());

        actor.attemptsTo(
                Click.on(UiCuentas.linkMasDetalles()),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTALIAS_DE_TARJETA), isVisible()).forNoMoreThan(30).seconds()
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.tarjetaDeCreditoMasDetalle);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTALIAS_DE_TARJETA)).isEqualTo(actor.recall(TDC_ALIAS.toString())),
                Ensure.that((String) datosObtenidos.get(TXTTIPO)).isEqualTo(actor.recall(TDC_TIPO.toString())),
                Ensure.that((String) datosObtenidos.get(TXTNUMERO)).isEqualTo(actor.recall(TDC_NUMERO2.toString())),
                Ensure.that((String) datosObtenidos.get(TXTSALDO_DISPONIBLE)).isEqualTo(actor.recall(TDC_SALDO_DISPONIBLE.toString())),
                Ensure.that((String) datosObtenidos.get(TXTSALDO_RETENIDO)).isNotEmpty(),
                Scroll.hastaElElemento(UiGenerico.campoSelector(TXTSOBREGIRO)).elementoVisibleEnElMedioDeLaPantalla()
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.tarjetaDeCreditoMasDetalle);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTLIMITE_OTORGADO)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTSOBREGIRO)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTPAGOMINIMO)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTPAGO_CONTADO)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTSALDO_A_PAGAR)).isEqualTo(actor.recall(TDC_SALDO_A_PAGAR.toString())),
                Scroll.hastaElElemento(UiGenerico.campoSelector(TXTTASA_INTERES))
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.tarjetaDeCreditoMasDetalle);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTFECHA_DE_PAGO)).isEqualTo(actor.recall(TDC_FECHA_PAGO.toString())),
                Ensure.that((String) datosObtenidos.get(TXTDIA_CORTE)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTTASA_INTERES)).isNotEmpty()
        );

    }

    public static ValidacionDetalleTDC para(List<Tarjetas> tarjeta) {
        return Instrumented.instanceOf(ValidacionDetalleTDC.class).withProperties(tarjeta);
    }
}