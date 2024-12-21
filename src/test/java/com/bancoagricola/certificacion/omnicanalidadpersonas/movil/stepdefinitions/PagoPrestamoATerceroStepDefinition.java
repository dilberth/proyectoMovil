package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actors.*;

import java.util.*;

public class PagoPrestamoATerceroStepDefinition {

    @Cuando("^realiza el pago de prestamo a tercero Nuevo desde la cuenta propia$")
    public void realizaElPagoDePrestamoATerceroNuevoDesdeLaCuentaPropia(List<Transferencias> informacionPago) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoPrestamoATercero.conLaInformacion(informacionPago)
        );

    }

    @Cuando("^realiza el pago de prestamo a tercero Nuevo desde la cuenta propia a un favorito$")
    public void realizaElPagoDePrestamoATerceroNuevoDesdeLaCuentaPropiaAUnFavorito(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoPrestamoATercero.conLaInformacion(informacionPago)
        );
    }

    @Entonces("^debe visualizar que el pago de prestamo a terceros fue exitoso y se le desconto el valor correcto de su cuenta$")
    public void debeVisualizarQueElPagoDePrestamoATercerosFueExitosoYSeLeDescontoElValorCorrectoDeSuCuenta(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidarTicketPagoPrestamoTercero.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionPago)
        );
    }

    @Cuando("^realiza el pago de prestamo a terceros desde la cuenta propia con bitcoins$")
    public void realizaElPagoDePrestamoDesdeLaCuentaPropiaTercerosConBitcoins(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoPrestamoATercero.conBitcoindDesdeMenuCuentasConLaInformacion(informacionPago)
        );
    }


}
