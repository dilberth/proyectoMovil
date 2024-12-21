package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actors.*;

import java.util.*;

public class PagoTarjetaTransfer365StepDefinition {

    @Cuando("^diligencia los campos para realizar el pago de tarjeta a otro banco usando Transfer 365 desde cero$")
    public void diligenciaLosCamposParaRealizarElPagoDeTarjetaAOtroBancoUsandoTransferDesdeCero(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoDeTarjetaTransfer365.conLaInformacion(informacionPago)
        );
    }

    @Cuando("^realiza el pago de tarjeta a otro banco usando Transfer 365 desde un favorito$")
    public void realizarElPagoDeTarhetaAOtroBancoUsandoTransfer365DesdeunFavorito(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoDeTarjetaTransfer365.conLaInformacion(informacionPago)
        );
    }

    @Entonces("^debe visualizar que el pago de tarjeta mediante el servicio de transfer 365 fue exitoso y se le desconto el valor correcto de su cuenta$")
    public void debeVisualizarQueElPagoDeTarjetaMedianteElServicioDeTransferFueExitosoYSeLeDescontoElValorCorrectoDeSuCuenta(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("Pago de tarjeta Transfer365: Operaciones entre bancos pendiente de aplicación"),
                ValidarTicketPagoTarjetaTransfer365.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionPago)
        );
    }

}
