package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoDeTransferenciaQr;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VolverInicio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarTicketTransferenciaQr;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Usuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class TransferenciaConQrStepDefinition {

    @Dado("^que se el valor de los saldos del usuario (.*) de sus puntos BA$")
    public void queSeElValorDeLosSaldosDeSusPuntosBa(Usuario usuario, List<Cuentas> informacionPago) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(usuario),
                ValidaPuntosBAAntes.para(informacionPago),
                VolverInicio.click()
        );
    }

    @Cuando("^realizo una transferencia con QR$")
    public void realizoUnaTransferenciaConQR(List<Cuentas> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoDeTransferenciaQr.para(datos),
                ValidacionTicketQR.elementos());
    }

    @Cuando("^realizo una transferencia con QR desde mi tarjeta de credito con la informacion$")
    public void realizoUnaTransferenciaConQRDesdeMiTarjetaDeCreditoConLaInformacion(List<Cuentas> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoDeTransferenciaQr.para(datos));
    }

    @Cuando("^realizo una transferencia con QR con mis puntos BA con la informacion$")
    public void realizoUnaTransferenciaConQRConMisPuntosBAConLaInformacion(List<Cuentas> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoDeTransferenciaQr.para(datos));
    }

    @Entonces("^la transferencias con QR debe ser exitosa y se debe  descontar el monto exacto de la cuenta origen$")
    public void elLaTransferenciasConQRDebeSerExitosaYSeDebeDescontarelMontoExacto(List<Cuentas> informacionDeTransferencia) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("Transferencia QR - Resultado"),
                ValidarTicketTransferenciaQr.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionDeTransferencia));
    }

    @Entonces("^la transferencias con QR debe ser exitosa y se debe  descontar el monto exacto de la tarjeta de credito$")
    public void elLaTransferenciasConQRDebeSerExitosaYSeDebeDescontarelMontoExactoDeLaTarjetaDeCredito(List<Cuentas> informacionDeTransferencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("Transferencia QR - Resultado"),
                ValidarTicketTransferenciaQr.enPantalla(),
                ValidaSaldosTarjetaCreditoDespues.para(informacionDeTransferencia));
    }


    @Entonces("^la transferencias con QR debe ser exitosa y se debe  descontar el monto exacto de los puntos BA$")
    public void laTransferenciasConQRDebeSerExitosaYSeDebeDescontarElMontoExactoDeLosPuntosBA(List<Cuentas> informacionDeTransferencia) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("Transferencia QR - Resultado"),
                ValidarTicketTransferenciaQr.enPantalla(),
                ValidaPuntosBADespues.para(informacionDeTransferencia)
        );
    }
}