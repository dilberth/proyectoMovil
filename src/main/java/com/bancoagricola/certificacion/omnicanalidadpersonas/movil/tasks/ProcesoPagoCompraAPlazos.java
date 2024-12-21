package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.*;

public class ProcesoPagoCompraAPlazos implements Task {

    private final Transferencias informacionPago;

    public ProcesoPagoCompraAPlazos(List<Transferencias> camposPago) {
        this.informacionPago = camposPago.get(0);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                IrAProducto.cuenta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.PAGO_DE_TARJETA.tomarTransaccion()));

        while (true) {
            if (UiCuentas.BTN_VER_MAS_TAR.resolveFor(actor).isVisible() == true) {
                actor.attemptsTo(
                        ClickEn.elElemento(UiCuentas.BTN_VER_MAS_TAR));
                Utilidades.esperar(2);
            } else {
                break;
            }
        }

        Utilidades.esperar(2);
        actor.attemptsTo(
                Scroll.hastaElElemento(UiGenerico.elementoDeTexto(informacionPago.getTarjetaCredito())),
                ClickEn.elElemento(UiGenerico.elementoDeTexto(informacionPago.getTarjetaCredito())),
                Esperar.pantallaDeCarga(),
                Ensure.that(UiGenerico.radioButton("Compra a plazos")).isDisplayed(),
                ClickEn.elElemento(UiGenerico.radioButton("Compra a plazos")),
                SeleccionarLista.conCordenadasDelNombre("Selecciona compra a plazo", TargetApp.soIsIos()).laOpcion(informacionPago.getcompraPlazo()),
                SeleccionarLista.conCordenadasDelNombre("Selecciona tipo de pago", TargetApp.soIsIos()).laOpcion("Otro monto"),
                IngresarEn.elCampo("Monto del pago").elValor(informacionPago.getMonto()),
                IngresarEn.elCampo("Concepto").elValor(informacionPago.getConcepto()),
                ClickEnBoton.elElemento("PAGAR"),
                Esperar.texto("¿Deseas continuar?"),
                ClickEnBoton.elElemento("ACEPTAR")
        );
    }

    public static Performable conLaInformacion(List<Transferencias> camposPago) {
        return Tasks.instrumented(ProcesoPagoCompraAPlazos.class, camposPago);
    }

}