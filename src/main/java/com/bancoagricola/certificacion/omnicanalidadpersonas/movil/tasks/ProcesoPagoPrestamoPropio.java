package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;

import java.util.*;

public class ProcesoPagoPrestamoPropio implements Task {

    private final Transferencias informacionPago;
    private final boolean menuCuentas;
    private final boolean pagoConBitcoins;

    public ProcesoPagoPrestamoPropio(List<Transferencias> info, boolean menuCuentas, boolean pagoConBitcoins) {
        this.informacionPago = info.get(0);
        this.menuCuentas = menuCuentas;
        this.pagoConBitcoins = pagoConBitcoins;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (menuCuentas) {
            actor.attemptsTo(
                    IrAProducto.cuenta(informacionPago.getNumeroPrestamo()).ySeleccionarLaTransaccion(TransaccionesPrestamos.PAGO_DE_PRESTRAMO.tomarTransaccion()));
        } else {
            actor.attemptsTo(
                    IrAProducto.cuenta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.PAGO_DE_PRESTRAMO.tomarTransaccion()),
                    ClickEn.elElemento(UiGenerico.elementoDeTexto(informacionPago.getNumeroPrestamo())));
        }

        actor.attemptsTo(
                Esperar.texto("Pago de préstamo propio"),
                IngresarEn.elCampo("Monto del pago").elValor(informacionPago.getMonto()),
                IngresarEn.elCampo("Concepto").elValor(informacionPago.getConcepto()));

        if (!pagoConBitcoins) {

            if (menuCuentas) {
                actor.attemptsTo(
                        SeleccionarLista.deNombre("Desde").laOpcion(informacionPago.getCuentaOrigen())
                );
            }
            actor.attemptsTo(
                    ClickEnBoton.elElemento("PAGAR"),
                    Esperar.texto("¿Deseas continuar?"),
                    ClickEnBoton.elElemento("ACEPTAR")
            );

        } else {
            actor.attemptsTo(
                    Scroll.hastaElElemento(UiGenerico.elementoDeTexto("Pagar con Bitcoin")),
                    ClickEnEnlace.deNombre("Pagar con Bitcoin")
            );
        }


    }

    public static ProcesoPagoPrestamoPropio desdeCuentaConLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoPrestamoPropio.class, informacionPago, false, false);
    }

    public static ProcesoPagoPrestamoPropio conBitcoindDesdeMenuCuentasConLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoPrestamoPropio.class, informacionPago, false, true);
    }

    public static ProcesoPagoPrestamoPropio desdeMenuCuentasConLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoPrestamoPropio.class, informacionPago, true, false);
    }
}