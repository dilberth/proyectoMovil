package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actions.Click;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BANNER_BANCO_AGRICOLA;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class TransferenciaCuentasPropiasStepDefinition {

    @Entonces("^realiza el proceso de logueo con el usuario (.*)$")
    public void realizaElProcesoDeLogueoConElUsuario(Usuario usuario) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(usuario));
    }

    @Dado("^valida los saldos antes de realizar la transacción$")
    public void validaLosSaldosAntesDeRealizarLaTransacción(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosDestinoAntesMOD1.para(datos),
                Click.on(BANNER_BANCO_AGRICOLA),
                ValidaSaldosOrigenAntesMOD1.para(datos));
    }

    @Dado("^realiza el traslado de saldo de la cuenta origen a la cuenta destino$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenALaCuentaDestino(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaCP.para(datos),
                ValidacionTicketCP.elementos());
    }

    @Entonces("^debe visualizar la disminucion en la cuenta de origen y un aumento en la cuenta destino$")
    public void debeVisualizarLaDisminucionEnLaCuentaDeOrigenYUnAumentoEnLaCuentaDeDestino(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosDestinoDespuesMOD1.para(datos),
                Click.on(BANNER_BANCO_AGRICOLA),
                ValidaSaldosOrigenDespuesMOD1.para(datos));
    }

    @Cuando("^valida el saldo de cuenta origen antes de realizar la transacción$")
    public void validaelSaldoDeCuentaOrigenAntesDeRealizarLaTransacción(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosOrigenAntesMOD1.para(datos));
    }

    @Cuando("^valida el saldo de cuenta antes de realizar la transacción$")
    public void validaelSaldoDeCuentaOrigenDeRealizarLaTransacción(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosOrigenAntes2.para(datos));
    }

    @Cuando("^valida que el favorito no se encuentre creado$")
    public void validaQueElFavoritoNoSeEncuentreCreado(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarFavoritos.con(datos));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta origen a cuenta de tercero y lo guarda como favorito$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenACuentaDeTerceroYLoGuardaComoFavorito(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaTerceroCuentaNueva3.para(datos),
                Esperar.texto("La transferencia se realizó exitosamente"),
                //AgregaFavorito.con(datos),
                ValidacionTicketTercerosCuenta.elementos());
    }

    @Cuando("^realiza el traslado de saldo de la cuenta origen a cuenta de tercero desde favorito$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenACuentaDeTerceroDesdeFavorito(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaTerceroCuentaFavorito.para(datos),
                ValidacionTicketTercerosCuenta.elementos());
    }

    @Cuando("^realiza el traslado de saldo de la cuenta origen celular asociado a cuenta$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenCelularAsociadoACuenta(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaTerceroCelular.para(datos),
                ValidacionTicketTercerosCelular.elementos());
    }

    @Cuando("^debe visualizar la disminucion en la cuenta de origen$")
    public void debeVisualizarLaDisminucionEnLaCuentaDeOrigen(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosOrigenDespuesMOD1.para(datos));
    }

    @Cuando("^debera visualizar la disminucion en la cuenta de origen$")
    public void deberaVisualizarLaDisminucionEnLaCuentaDeOrigen(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaSaldosOrigenDespues.para(datos));
    }
}