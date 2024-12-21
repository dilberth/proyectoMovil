package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;

import java.util.*;

public class ProcesoPagoServiciosNpe implements Task {

    private final Transferencias informacionPago;
    private final boolean menuCuentas;

    public ProcesoPagoServiciosNpe(List<Transferencias> informacionPago, boolean menuCuentas) {
        this.informacionPago = informacionPago.get(0);
        this.menuCuentas = menuCuentas;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        if (menuCuentas) {
            IrAProducto.cuenta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.PAGO_DE_SERVICIOS.tomarTransaccion()).performAs(actor);
        } else {
            IrAProducto.tarjeta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesTarjetas.PAGO_DE_SERVICIOS.tomarTransaccion()).performAs(actor);
        }

        actor.attemptsTo(
                Click.on(UiPagos.pagoConFactura()),
                Click.on(UiPagos.codigoNPE()),
                Esperar.texto("Digita el NPE o escanea el código de barra", 10),
                EscribirConJs.elTexto(informacionPago.getNpe()).enElCampo(UiPagos.codigoNPE()),
                ClickEnBoton.elElemento("CONTINUAR"));
                Utilidades.esperar(15);
        actor.attemptsTo(
                Esperar.texto("Monto a abonar",20),
                IngresarEn.elCampo("Monto a abonar").elValor(informacionPago.getMonto()),
                ClickEnBoton.elElemento("PAGAR"),
                Esperar.texto("¿Deseas continuar?"),
                ClickEnBoton.elElemento("ACEPTAR")
        );

    }

    public static ProcesoPagoServiciosNpe desdeMenuDeCuentasConLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoServiciosNpe.class, informacionPago, true);
    }

    public static ProcesoPagoServiciosNpe desdeMenuDeTarjetasConLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoServiciosNpe.class, informacionPago, false);
    }
}
