package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.InformacionPagoAmigo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.TargetApp;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesCuentas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

public class ProcesoPagoAmigo implements Task {

    private final InformacionPagoAmigo infoCobro;

    public ProcesoPagoAmigo(List<InformacionPagoAmigo> infoCobro) {
        this.infoCobro = infoCobro.get(0);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                IrAProducto.cuenta(infoCobro.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.COBRO_PAGO_AMIGO.tomarTransaccion()),
                ClickEn.elElemento(UiGenerico.elementoDeTexto("Pagar")),
                ClickEn.elElemento(UiGenerico.elementoDeTexto(infoCobro.getNombre())),
                Esperar.texto("Pago a un amigo"),
                IngresarEn.elCampo("Ingrese el monto que desea pagar").elValor(infoCobro.getMonto()),
                IngresarEn.elCampo("Concepto").elValor(infoCobro.getConcepto()),
                ClickEnBoton.elElemento("CONTINUAR"),
                Esperar.texto("¿Deseas continuar?"),
                ClickEnBoton.elElemento("ACEPTAR"),
                Esperar.texto("El pago se realizó exitosamente")
        );
    }

    public static ProcesoPagoAmigo conLaInformacion(List<InformacionPagoAmigo> info) {
        return Tasks.instrumented(ProcesoPagoAmigo.class,info);
    }


}
