package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesCuentas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;


public class ProcesoPagoPrestamoATercero implements Task {

    private final Transferencias informacionPago;
    private boolean pagoConBitcoins = false;

    public ProcesoPagoPrestamoATercero(List<Transferencias> info) {
        this.informacionPago = info.get(0);
    }

    public ProcesoPagoPrestamoATercero(List<Transferencias> info, boolean pagoConBitcoins) {
        this.informacionPago = info.get(0);
        this.pagoConBitcoins = pagoConBitcoins;
    }

    public ProcesoPagoPrestamoATercero(Transferencias info) {
        this.informacionPago = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IrAProducto.cuenta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.PAGO_DE_PRESTRAMO.tomarTransaccion())
        );

        if (informacionPago.getNombrefavorito() == null) {
            actor.attemptsTo(
                    ClickEn.elElemento(UiPrestamos.pagarPrestamoTerceros()),
                    Esperar.texto("Pago de préstamo a tercero"),
                    IngresarEn.elCampo("Número de préstamo").elValor(informacionPago.getNumeroPrestamo()),
                    IngresarEn.elCampo("Correo electrónico").elValor(informacionPago.getCorreo())
            );
        } else {
            actor.attemptsTo(
                    Scroll.hastaElElemento(UiGenerico.elementoDeTexto(informacionPago.getNombrefavorito())).elementoVisibleEnElMedioDeLaPantalla(),
                    ClickEn.elElemento(UiGenerico.elementoDeTexto(informacionPago.getNombrefavorito()))
            );
        }

        actor.attemptsTo(
                IngresarEn.elCampo("Monto del pago").elValor(informacionPago.getMonto()),
                IngresarEn.elCampo("Concepto").elValor(informacionPago.getConcepto())
        );

        if (!pagoConBitcoins) {

            ClickEnBoton.elElemento("PAGAR").performAs(actor);

            actor.attemptsTo(
                    Esperar.texto("¿Deseas continuar?"),
                    ClickEnBoton.elElemento("ACEPTAR"),
                    Esperar.texto("El préstamo se pagó exitosamente")
            );

        } else {

            actor.attemptsTo(
                    Scroll.hastaElElemento(UiGenerico.elementoDeTexto("Pagar con Bitcoin")),
                    ClickEnEnlace.deNombre("Pagar con Bitcoin")
            );
        }

    }

    public static ProcesoPagoPrestamoATercero conLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoPrestamoATercero.class, informacionPago);
    }

    public static ProcesoPagoPrestamoATercero conLaInformacion(Transferencias informacionPago) {
        return Tasks.instrumented(ProcesoPagoPrestamoATercero.class, informacionPago);
    }

    public static ProcesoPagoPrestamoATercero conBitcoindDesdeMenuCuentasConLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoPrestamoATercero.class, informacionPago, true);
    }

}
