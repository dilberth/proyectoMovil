package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actors.*;

import java.util.*;

public class PagoTarjetaTerceroStepDefinition {

    @Cuando("^realiza el pago de tarjeta a tercero desde la cuenta propia$")
    public void realizaElPagoDeTarjetaTerceroNuevoDesdeLaCuentaPropia(List<Transferencias> informacionPago) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoTarjetaTercero.conLaInformacion(informacionPago));
    }

    @Cuando("^realiza el pago de tarjeta tercero Nuevo desde la cuenta propia a un favorito$")
    public void realizaElPagoDeTarjetaTerceroNuevoDesdeLaCuentaPropiaAUnFavorito(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoTarjetaTercero.conLaInformacion(informacionPago));
    }

    @Entonces("^debe visualizar que el pago de tarjeta terceros fue exitoso y se le desconto el valor correcto de su cuenta$")
    public void debeVisualizarQueElPagoDeTArjetaTercerosFueExitosoYSeLeDescontoElValorCorrectoDeSuCuenta(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("La tarjeta se pagó exitosamente"),
                ValidarTicketPagoTarjetaTercero.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionPago));
    }

    @Cuando("^realiza el pago de tarjeta a terceros desde la cuenta propia con bitcoins$")
    public void realizaElPagoDeTarjetaDesdeLaCuentaPropiaTercerosConBitcoins(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoTarjetaTercero.conBitcoindDesdeMenuCuentasConLaInformacion(informacionPago));
    }
}
