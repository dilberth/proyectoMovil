package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.ScrollVertical;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesCuentas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

public class ProcesoPagoTarjetaUni implements Task {

    private final Transferencias informacionPago;

    public ProcesoPagoTarjetaUni(List<Transferencias> info) {
        this.informacionPago = info.get(0);
    }

    public ProcesoPagoTarjetaUni(Transferencias info) {
        this.informacionPago = info;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IrAProducto.cuenta(informacionPago.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.PAGO_TARJETA_UNI.tomarTransaccion())
        );

        if (informacionPago.getNombrefavorito() == null) {
            actor.attemptsTo(
                    ClickEn.elElemento(UiTarjetas.pagarOtraTarjeta()),
                    Esperar.texto("Pago de tarjeta UNI: Operaciones entre bancos"),
                    SeleccionarLista.conCordenadasDelNombre("Banco", TargetApp.soIsIos()).laOpcion(informacionPago.getBanco()),
                    IngresarEn.elCampo("Tarjeta a abonar").elValor(informacionPago.getTarjetaOtroBanco()),
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
                Esperar.texto("¿Deseas continuar?")
        );

        ScrollVertical.medio().desdeElMedio().ejecutar();

        actor.attemptsTo(
                ClickEnBoton.elElemento("ACEPTAR")
        );

        Esperar.texto("Pago de tarjeta UNI: Operaciones entre bancos pendiente de aplicación").performAs(actor);

    }

    public static ProcesoPagoTarjetaUni conLaInformacion(List<Transferencias> informacionPago) {
        return Tasks.instrumented(ProcesoPagoTarjetaUni.class, informacionPago);
    }

    public static ProcesoPagoTarjetaUni conLaInformacion(Transferencias informacionPago) {
        return Tasks.instrumented(ProcesoPagoTarjetaUni.class, informacionPago);
    }

}
