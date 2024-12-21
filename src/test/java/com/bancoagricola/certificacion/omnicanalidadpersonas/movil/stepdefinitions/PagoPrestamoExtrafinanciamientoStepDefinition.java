package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actors.*;

import java.util.*;

public class PagoPrestamoExtrafinanciamientoStepDefinition {
    @Cuando("^realiza el pago de extrafinanciamiento usando una cuenta propia$")
    public void realizaElPagoDeExtrafinanciamientoUsandoUnaCuentaPropia(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoPrestamoExtrafinanciamiento.conLaInformacion(informacionPago)
        );
    }

    @Entonces("^debe visualizar que el pago de prestamo de extrafinanciamiento fue exitoso y diminuyo el saldo de cuenta la origen por el valor del pago$")
    public void debeVisualizarQueElPagoDePrestamoDeExtrafinanciamientoFueExitosoYDiminuyoElSaldoDeCuentaLaOrigenPorElValorDelPago(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidarTicketPagoPrestamoExtrafinanciamiento.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionPago)
        );
    }

}