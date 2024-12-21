package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.*;

import java.util.*;

public class ProcesoPagoDeTarjetaTransfer365 implements Task {

    private final Transferencias informacionPago;

    public ProcesoPagoDeTarjetaTransfer365(List<Transferencias> informacionPago) {
        this.informacionPago = informacionPago.get(0);
    }

    public ProcesoPagoDeTarjetaTransfer365(Transferencias informacionPago) {
        this.informacionPago = informacionPago;
    }

    @Step("{0} realiza el proceso de pago de prestamo transfer 365")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IrAProducto.cuenta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.PAGO_TARJETA_TRANSFER365.tomarTransaccion())
        );

        if (informacionPago.getNombrefavorito() == null) {
            actor.attemptsTo(
                    ClickEn.elElemento(UiTarjetas.pagarOtraTarjeta()),
                    SeleccionarLista.deNombre("Institución destino").laOpcion(informacionPago.getBanco()),
                    IngresarEn.elCampo("Tarjeta a abonar").elValor(informacionPago.getCuentaDestino()),
                    SeleccionarLista.deNombre("Tipo de cliente recibidor").laOpcion(informacionPago.getTipoCliente()),
                    IngresarEn.elCampo("Nombre del recibidor").elValor(informacionPago.getNombreRecibidor()),
                    IngresarEn.elCampo("Apellido del recibidor").elValor(informacionPago.getApellidoRecibidor()),
                    IngresarEn.elCampo("Correo electrónico").elValor(informacionPago.getCorreo())
            );
        } else {
            actor.attemptsTo(
                    Ensure.that(UiGenerico.elementoDeTexto("No hay tarjetas de crédito habilitadas")).isNotDisplayed(),
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
                Esperar.pantallaDeCarga(),
                Esperar.texto("Pago de tarjeta Transfer365: Operaciones entre bancos pendiente de aplicación")
                );

    }

    public static ProcesoPagoDeTarjetaTransfer365 conLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoDeTarjetaTransfer365.class, informacionPago);
    }

    public static ProcesoPagoDeTarjetaTransfer365 conLaInformacion(Transferencias informacionPago) {
        return Tasks.instrumented(ProcesoPagoDeTarjetaTransfer365.class, informacionPago);
    }

}
