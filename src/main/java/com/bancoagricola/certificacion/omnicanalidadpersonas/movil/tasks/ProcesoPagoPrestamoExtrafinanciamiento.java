package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesPrestamos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.*;
import net.serenitybdd.screenplay.targets.*;

import java.util.List;

public class ProcesoPagoPrestamoExtrafinanciamiento implements Task {

    private final Transferencias informacionPago;

    public ProcesoPagoPrestamoExtrafinanciamiento(List<Transferencias> informacionPago) {
        this.informacionPago = informacionPago.get(0);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Check.whether(TargetApp.soIsIos()).andIfSo(
                        IrAProducto.cuenta(informacionPago.getNumeroPrestamo()).verMas(),
                        ClickEn.elElemento(Target.the("Pagar extra- financimiento").locatedBy("//*[contains(@label,'Pagar extra-') and contains (@label,'financimiento')]"))
                ).otherwise(
                        IrAProducto.cuenta(informacionPago.getNumeroPrestamo()).ySeleccionarLaTransaccion(TransaccionesPrestamos.PAGAR_EXTRA_FINANCIAMIENTO.tomarTransaccion())
                ),
                Esperar.texto("Pago de extrafinanciamiento"),
                SeleccionarLista.deNombre("Tipo de pago").laOpcion("Otro monto"),
                IngresarEn.elCampo("Monto a pagar").elValor(informacionPago.getMonto()),
                IngresarEn.elCampo("Concepto").elValor(informacionPago.getConcepto()),
                SeleccionarLista.deNombre("Desde").laOpcion(informacionPago.getCuentaOrigen()),
                ClickEnBoton.elElemento("PAGAR"),
                Esperar.texto("¿Deseas continuar?"),
                ClickEnBoton.elElemento("ACEPTAR"),
                Esperar.texto("El extrafinanciamiento se pagó exitosamente")
        );


    }

    public static ProcesoPagoPrestamoExtrafinanciamiento conLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoPrestamoExtrafinanciamiento.class, informacionPago);
    }

}
