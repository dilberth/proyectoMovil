package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Ahorros;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaAhorroProgramadoStepDefinition {

    @Cuando("^valida el saldo de ahorro programado antes de realizar la transacción$")
    public void validaElSaldoDeAhorroProgramadoAntesDeRealizarLaTransacción(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosAhorroProgramadoAntes.para(datos));
    }

    @Cuando("^realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino$")
    public void realizaElProcesoDeTransferenciaDeSaldoDeLaCuentaOrigenALaCuentaDestino(List<Ahorros> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaAPaCP.para(datos),
                ValidacionTicketCP.elementos());
    }

    @Cuando("^debe visualizar la disminucion en el ahorro programado$")
    public void debeVisualizarLaDisminucionEnElAhorroProgramado(List<Cuentas> datos) {
        Utilidades.esperar(2);
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosAhorroProgramadoDespues.para(datos));
    }

    @Dado("^realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino tercero seleccionando cuenta$")
    public void realizaElProcesoDeTransferenciaDeSaldoDeLaCuentaOrigenALaCuentaDestinoTerceroSeleccionandoCuenta(List<Ahorros> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaAP_Tercero.para(datos),
                ValidacionTicketTercerosCuenta.elementos());
    }

    @Dado("^realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino tercero seleccionando celular$")
    public void realizaElProcesoDeTransferenciaDeSaldoDeLaCuentaOrigenALaCuentaDestinoTerceroSeleccionandoCelular(List<Ahorros> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaAP_TerceroCelular.para(datos),
                ValidacionTicketTercerosCelular.elementos());
    }
}