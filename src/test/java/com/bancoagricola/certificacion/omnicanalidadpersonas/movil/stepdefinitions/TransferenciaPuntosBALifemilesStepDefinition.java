package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actions.Click;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BANNER_BANCO_AGRICOLA;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class TransferenciaPuntosBALifemilesStepDefinition {

    @Cuando("^valida los saldo de cuenta origen y para Puntos BA antes de realizar la transacción$")
    public void validaLosSaldoDeCuentaOrigenYParaPuntosBAAntesDeRealizarLaTransacción(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosOrigenAntesMOD1.para(datos),
                Click.on(BANNER_BANCO_AGRICOLA),
                ValidaPuntosBAAntes.para(datos));
    }

    @Cuando("^debe visualiza la disminucion de Puntos BA y en el saldo de la cuenta de origen$")
    public void debeVisualizarLaDisminucionDePuntosBAYEnElSAldoDeLaCuentaDeOrigen(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaPuntosBADespues.para(datos),
                Click.on(BANNER_BANCO_AGRICOLA),
                ValidaSaldosOrigenDespuesMOD1.para(datos));
    }

    @Cuando("^debe visualizar la disminucion en Puntos BA posterior a realizar la transacción$")
    public void debeVisualizarLaDisminucionEnPuntosBAPosteriorARealizarLaTransacción(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaPuntosBADespues.para(datos));
    }

    @Cuando("^realiza el proceso de transferencia de Puntos BA a Lifemiles$")
    public void realizaElProcesoDeTransferenciaDePuntosBAALifemiles(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaPuntosBALifemiles.para(datos),
                ValidacionTicketPuntoALifemiles.elementos());
    }

    @Entonces("^debe visualizar la disminucion de saldo en la cuenta de origen$")
    public void debeVisualizarLaDisminucionDeSaldoEnLaCuentaDeOrigen(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosOrigenDespues.para(datos));
    }
}
