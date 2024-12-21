package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Tarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BANNER_BANCO_AGRICOLA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaTarjetaCreditoStepDefinition {

    @Cuando("^valida el saldo de cuenta destino antes de realizar la transacción$")
    public void validaelSaldoDeCuentaDestinoAntesDeRealizarLaTransacción(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosDestinoAntesMOD1.para(datos),
                Click.on(BANNER_BANCO_AGRICOLA));
    }

    @Cuando("^valida el saldo de la tarjeta de credito antes de realizar la transacción$")
    public void validaElSaldoDeLaTarjetaDeCreditoAntesDeRealizarLaTransacción(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosTarjetaCreditoAntes.para(datos));
    }

    @Cuando("^realiza la transferencia desde la tarjeta de credito hacia la cuenta destino$")
    public void realizaLaTransferenciaDesdeLaTarjetaDeCreditoHaciaLaCuentaDestino(List<Tarjetas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaTCaCP.para(datos),
                ValidacionTicketCP.elementos());
    }

    @Cuando("^debe visualizar un aumento en la cuenta destino$")
    public void debeVisualizarUnAumentoEnLaCuentaDestino(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BANNER_BANCO_AGRICOLA),
                ValidaSaldosDestinoDespuesMOD1.para(datos));
    }

    @Entonces("^debe visualizar la disminucion en la tarjeta de credito$")
    public void debeVisualizarLaDisminucionEnLaTarjetaDeCredito(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosTarjetaCreditoDespues.para(datos));
    }
}