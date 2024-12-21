package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesCuentas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

public class ProcesoPagoPrestamoUni implements Task {

    private final Transferencias informacionPago;

    public ProcesoPagoPrestamoUni(List<Transferencias> info) {
        this.informacionPago = info.get(0);
    }

    public ProcesoPagoPrestamoUni(Transferencias info) {
        this.informacionPago = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IrAProducto.cuenta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.PAGO_PRESTAMO_UNI.tomarTransaccion())
        );

        if (informacionPago.getNombrefavorito() == null || informacionPago.getNombrefavorito().isEmpty()) {
            actor.attemptsTo(
                    ClickEn.elElemento(UiPrestamos.pagarOtrosPrestamo()),
                    Esperar.texto("Pago de Préstamo UNI: Operaciones entre bancos"),
                    SeleccionarLista.conCordenadasDelNombre("Banco", TargetApp.soIsIos()).laOpcion(informacionPago.getBanco()),
                    IngresarEn.elCampo("Préstamo a abonar").elValor(informacionPago.getNumeroPrestamo()),
                    SeleccionarLista.conCordenadasDelNombre("Tipo de documento",TargetApp.soIsIos()).laOpcion(informacionPago.getTipoIdentificacion()),
                    IngresarEn.elCampo("Número de documento").elValor(informacionPago.getNumeroIdentificacion()),
                    IngresarEn.elCampo("Nombre de recibidor").elValor(informacionPago.getNombreRecibidor()),
                    IngresarEn.elCampo("Correo electrónico").elValor(informacionPago.getCorreo())
            );
        } else {
            actor.attemptsTo(
                    ClickEn.elElemento(UiGenerico.elementoDeTexto   (informacionPago.getNombrefavorito()))
            );
        }

        actor.attemptsTo(
                IngresarEn.elCampo("Monto").elValor(informacionPago.getMonto()),
                IngresarEn.elCampo("Concepto").elValor(informacionPago.getConcepto()),
                ClickEnBoton.elElemento("PAGAR"),
                Esperar.texto("¿Deseas continuar?"),
                Scroll.simple(),
                ClickEnBoton.elElemento("ACEPTAR"),
                Esperar.pantallaDeCarga()
        );

    }

    public static ProcesoPagoPrestamoUni conLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoPrestamoUni.class, informacionPago);
    }

    public static ProcesoPagoPrestamoUni conLaInformacion(Transferencias informacionPago) {
        return Tasks.instrumented(ProcesoPagoPrestamoUni.class, informacionPago);
    }

}
