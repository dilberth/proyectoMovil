package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Limites;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.LimiteAcumulableSemanal;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.LimitePorTransaccion;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTLIMITE_ACU;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTLIMITE_TRX;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.LIMITE_CAN;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.LIMITE_TRX;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LimiteAcumuladoTransaccionStepDefinition {

    @Cuando("^actualiza los valores de limites de transacción y valida ticket$")
    public void actualizaLosValoresDeLimitesDeTransacciónYValidaTicket(List<Limites> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoActualizacionLimiteTRX.para(datos),
                ValidacionTicketLimiteTRX.elementos());
    }

    @Cuando("^realiza el traslado de saldo de la cuenta origen a cuenta de tercero$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenACuentaDeTercero(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaTerceroCuentaNueva.para(datos));
    }

    @Cuando("^realiza el traslado de saldo de la cuenta origen a cuenta de terceros$")
    public void realizaElTrasladoDeSaldoDeLaCuentaOrigenACuentaDeTerceros(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaTerceroCuentaNueva3.para(datos),
                Esperar.texto("La transferencia se realizó exitosamente", 30),
                ValidacionTicketTercerosCuenta.elementos());
    }

    @Entonces("^valida mensaje y reestablece el valor de limite de transacción por defecto$")
    public void validaMensajeYReestableceElValorDeLimiteDeTransacciónPorDefecto(List<Limites> datos) {

        theActorInTheSpotlight().attemptsTo(
                ValidacionTransaccion.para(datos),
                ProcesoActualizacionLimiteTRX.para(datos));
        theActorInTheSpotlight().should(seeThat(LimitePorTransaccion.sea(), equalTo(theActorInTheSpotlight().recall(LIMITE_TRX.toString()))).because(theActorInTheSpotlight().toString() + " valida que el valor de '" + TXTLIMITE_TRX + "' sea igual a: '$" + theActorInTheSpotlight().recall(LIMITE_TRX.toString()) + "'"));
    }

    @Cuando("^actualiza los valores de limites de canal y limites de transacción y valida ticket$")
    public void actualizaLosValoresDeLimitesDeCanalYLimitesDeTransacciónYValidaTicket(List<Limites> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoActualizacionLimiteAcu.para(datos),
                ValidacionTicketLimiteAcu.elementos());
    }

    @Entonces("^valida mensaje y reestablece los valores de limite de transacción y limite acumulado por defecto$")
    public void validaMensajeYReestableceLosValoresDeLimiteDeTransacciónYLimiteAcumuladoPorDefecto(List<Limites> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionTransaccion.para(datos),
                ProcesoActualizacionLimiteAcu.para(datos));
        theActorInTheSpotlight().should(seeThat(LimiteAcumulableSemanal.sea(), equalTo(theActorInTheSpotlight().recall(LIMITE_CAN.toString()))).because(theActorInTheSpotlight().toString() + " valida que el valor de '" + TXTLIMITE_ACU + "' sea igual a: '$" + theActorInTheSpotlight().recall(LIMITE_CAN.toString()) + "'"));
        theActorInTheSpotlight().should(seeThat(LimitePorTransaccion.sea(), equalTo(theActorInTheSpotlight().recall(LIMITE_TRX.toString()))).because(theActorInTheSpotlight().toString() + " valida que el valor de '" + TXTLIMITE_TRX + "' sea igual a: '$" + theActorInTheSpotlight().recall(LIMITE_TRX.toString()) + "'"));
    }
}