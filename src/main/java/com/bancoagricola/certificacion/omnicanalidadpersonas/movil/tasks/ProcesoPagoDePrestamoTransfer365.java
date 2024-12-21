package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;

import java.util.*;


public class ProcesoPagoDePrestamoTransfer365 implements Task {

    private final Transferencias informacionPago;

    public ProcesoPagoDePrestamoTransfer365(List<Transferencias> informacionPago) {
        this.informacionPago = informacionPago.get(0);
    }

    public ProcesoPagoDePrestamoTransfer365(Transferencias informacionPago) {
        this.informacionPago = informacionPago;
    }

    @Step("{0} realiza el proceso de pago de prestamo transfer 365")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IrAProducto.cuenta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.PAGO_PRESTAMO_TRANSFER365.tomarTransaccion())
        );

        if (informacionPago.getNombrefavorito() == null || informacionPago.getNombrefavorito().isEmpty()) {
            actor.attemptsTo(
                    ClickEn.elElemento(UiPrestamos.pagarOtrosPrestamo()),
                    Esperar.texto("Pago de préstamo Transfer365: Operaciones entre bancos"),
                    SeleccionarLista.conCordenadasDelNombre("Institución destino", TargetApp.soIsIos()).laOpcion(informacionPago.getBanco()),
                    IngresarEn.elCampo("Préstamo a abonar").elValor(informacionPago.getCuentaDestino()),
                    SeleccionarLista.conCordenadasDelNombre("Tipo de cliente recibidor", TargetApp.soIsIos()).laOpcion(informacionPago.getTipoCliente()),
                    IngresarEn.elCampo("Nombre del recibidor").elValor(informacionPago.getNombreRecibidor()),
                    IngresarEn.elCampo("Apellido del recibidor").elValor(informacionPago.getApellidoRecibidor()),
                    IngresarEn.elCampo("Correo electrónico").elValor(informacionPago.getCorreo())
            );
        } else {
            actor.attemptsTo(
                    Scroll.hastaElElemento(UiGenerico.elementoDeTexto(informacionPago.getNombrefavorito())),
                    ClickEn.elElemento(UiGenerico.elementoDeTexto(informacionPago.getNombrefavorito()))
            );
        }
        actor.attemptsTo(
                IngresarEn.elCampo("Monto").elValor(informacionPago.getMonto()),
                IngresarEn.elCampo("Concepto").elValor(informacionPago.getConcepto()),
                ClickEnBoton.elElemento("PAGAR"),
                Esperar.texto("¿Deseas continuar?"),
                Scroll.simple(),
                ClickEnBoton.elElemento("ACEPTAR"),
                Esperar.texto("Pago de préstamo Transfer365: Operaciones entre bancos pendiente de aplicación")
        );
    }

    public static ProcesoPagoDePrestamoTransfer365 conLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoDePrestamoTransfer365.class, informacionPago);
    }

    public static ProcesoPagoDePrestamoTransfer365 conLaInformacion(Transferencias informacionPago) {
        return Tasks.instrumented(ProcesoPagoDePrestamoTransfer365.class, informacionPago);
    }
}


