package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesCuentas;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProcesoPagoTarjetaTercero implements Task {

    private final Transferencias informacionPago;
    private boolean pagoConBitcoins = false;

    public ProcesoPagoTarjetaTercero(List<Transferencias> info) {
        this.informacionPago = info.get(0);
    }

    public ProcesoPagoTarjetaTercero(Transferencias info) {
        this.informacionPago = info;
    }

    public ProcesoPagoTarjetaTercero(List<Transferencias> info,boolean pagoConBitcoins) {
        this.informacionPago = info.get(0);
        this.pagoConBitcoins = pagoConBitcoins;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IrAProducto.cuenta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.PAGO_DE_TARJETA.tomarTransaccion()));

        if (informacionPago.getNombrefavorito() == null || informacionPago.getNombrefavorito() == "") {
            actor.attemptsTo(
                    ClickEn.elElemento(UiTarjetas.pagarTarjetaATerceros()),
                    Esperar.texto("Pago de tarjeta de crédito de terceros"),
                    IngresarEn.elCampo("Número de tarjeta").elValor(informacionPago.getTarjetaCreditoTercero()),
                    IngresarEn.elCampo("Correo electrónico").elValor(informacionPago.getCorreo()));
        } else {
            actor.attemptsTo(
                    Scroll.simple(),
                    Scroll.hastaElElemento(UiGenerico.FAVORITO.of(informacionPago.getNombrefavorito())).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(UiGenerico.FAVORITO.of(informacionPago.getNombrefavorito()), isVisible()).forNoMoreThan(5).seconds(),
                    ClickEn.elElemento(UiGenerico.FAVORITO.of(informacionPago.getNombrefavorito())));
        }
        actor.attemptsTo(
                IngresarEn.elCampo("Monto a pagar").elValor(informacionPago.getMonto()),
                IngresarEn.elCampo("Concepto").elValor(informacionPago.getConcepto()));
        if (!pagoConBitcoins) {
            actor.attemptsTo(
                    ClickEnBoton.elElemento("PAGAR"),
                    Esperar.texto("¿Deseas continuar?"),
                    ClickEnBoton.elElemento("ACEPTAR"));
        } else {
            actor.attemptsTo(
                    Scroll.hastaElElemento(UiGenerico.elementoDeTexto("Pagar con Bitcoin")),
                    ClickEnEnlace.deNombre("Pagar con Bitcoin"));
        }

    }

    public static ProcesoPagoTarjetaTercero conLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoTarjetaTercero.class, informacionPago);
    }

    public static ProcesoPagoTarjetaTercero conLaInformacion(Transferencias informacionPago) {
        return Tasks.instrumented(ProcesoPagoTarjetaTercero.class, informacionPago);
    }

    public static ProcesoPagoTarjetaTercero conBitcoindDesdeMenuCuentasConLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoTarjetaTercero.class, informacionPago,true);
    }

}
