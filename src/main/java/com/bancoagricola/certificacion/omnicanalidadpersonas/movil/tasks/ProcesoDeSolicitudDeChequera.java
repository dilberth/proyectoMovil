package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEnBoton;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IrAProducto;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.SeleccionarLista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Boton;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesCuentas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.AGENCIA;

public class ProcesoDeSolicitudDeChequera implements Task {

    private final Transferencias informacionParaSolicitudChequera;

    public ProcesoDeSolicitudDeChequera(List<Transferencias> informacionSolicitudChequera) {
        this.informacionParaSolicitudChequera = informacionSolicitudChequera.get(0);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IrAProducto.cuenta(informacionParaSolicitudChequera.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.SOLICTUD_DE_CHEQUERAS.tomarTransaccion()),
                Esperar.texto("Solicitud de chequeras"),
                SeleccionarLista.conCordenadasDelNombre("Tipo de chequera", TargetApp.soIsIos()).laOpcion(informacionParaSolicitudChequera.getTipoChequera()),
                SeleccionarLista.conCordenadasDelNombre("Cantidad de cheques", TargetApp.soIsIos()).laOpcion(informacionParaSolicitudChequera.getCantidadCheques()),
                SeleccionarLista.conCordenadasDelNombre("Departamento", TargetApp.soIsIos()).laOpcion(informacionParaSolicitudChequera.getDepartamentoEntrega()),
                SeleccionarLista.conCordenadasDelNombre(AGENCIA, TargetApp.soIsIos()).laOpcion(informacionParaSolicitudChequera.getAgenciaEntrega()),
                ClickEnBoton.elElemento(Boton.CONTINUAR),
                Esperar.texto("¿Deseas continuar?"),
                Scroll.simple(),
                ClickEnBoton.elElemento("ACEPTAR"));
    }

    public static ProcesoDeSolicitudDeChequera conLaInformacion(List<Transferencias> informacionSolicitudChequera) {
        return Tasks.instrumented(ProcesoDeSolicitudDeChequera.class, informacionSolicitudChequera);
    }
}