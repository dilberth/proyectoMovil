package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesCuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

public class ProcesoPagoTarjetaPropia implements Task {

    private final Transferencias informacionPago;
    private final boolean menuCuentas;
    private boolean pagoConBitcoins = false;


    public ProcesoPagoTarjetaPropia(List<Transferencias> info, boolean menuCuentas) {
        this.informacionPago = info.get(0);
        this.menuCuentas = menuCuentas;
    }

    public ProcesoPagoTarjetaPropia(List<Transferencias> info, boolean menuCuentas, boolean pagoConBitcoins) {
        this.informacionPago = info.get(0);
        this.menuCuentas = menuCuentas;
        this.pagoConBitcoins = pagoConBitcoins;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (menuCuentas) {
            actor.attemptsTo(
                    IrAProducto.tarjeta(informacionPago.getTarjetaCredito()).ySeleccionarLaTransaccion(TransaccionesTarjetas.PAGO_DE_TARJETA.tomarTransaccion())
            );
        } else {
            actor.attemptsTo(
                    IrAProducto.cuenta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.PAGO_DE_TARJETA.tomarTransaccion()),
                    ClickEn.elElemento(UiGenerico.elementoDeTexto(informacionPago.getTarjetaCredito()))
            );
        }

        actor.attemptsTo(
                Esperar.texto("Pago de tarjeta de crédito propia"),
                SeleccionarLista.deNombre("Selecciona tipo de pago").laOpcion("Otro monto"),
                IngresarEn.elCampo("Monto del pago").elValor(informacionPago.getMonto()),
                IngresarEn.elCampo("Concepto").elValor(informacionPago.getConcepto())
        );

        if (menuCuentas) {
            actor.attemptsTo(
                    SeleccionarLista.deNombre("Desde").laOpcion(informacionPago.getCuentaOrigen())
            );
        }

        if (!pagoConBitcoins) {

            actor.attemptsTo(
                    ClickEnBoton.elElemento("PAGAR"),
                    Esperar.texto("¿Deseas continuar?"),
                    ClickEnBoton.elElemento("ACEPTAR")
            );

        } else {

            Scroll.hastaElElemento(UiGenerico.elementoDeTexto("Pagar con Bitcoin")).performAs(actor);
            ClickEnEnlace.deNombre("Pagar con Bitcoin").performAs(actor);


        }

    }

    public static ProcesoPagoTarjetaPropia desdeCuentaConLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoTarjetaPropia.class, informacionPago, false);
    }

    public static ProcesoPagoTarjetaPropia desdeMenuTarjetasConLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoTarjetaPropia.class, informacionPago, true);
    }

    public static ProcesoPagoTarjetaPropia conBitcoindDesdeMenuCuentasConLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoTarjetaPropia.class, informacionPago, false, true);
    }


}
