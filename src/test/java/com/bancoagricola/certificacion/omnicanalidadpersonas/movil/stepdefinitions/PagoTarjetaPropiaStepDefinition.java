package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VolverInicio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarQueElUltimoMovimientoCuenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarTicketPagoTarjetaPropia;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class PagoTarjetaPropiaStepDefinition {

    @Cuando("^realiza el pago de tarjeta desde cuentas con los datos$")
    public void realizoElPagoDeTarjetaDesdeCuentasConLosDatos(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoTarjetaPropia.desdeCuentaConLaInformacion(informacionPago)
        );
    }

    @Cuando("^realiza el pago de tarjeta desde tarjetas con los datos$")
    public void realizoElPagoDeTarjetaDesdeTarjetasConLosDatos(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoTarjetaPropia.desdeMenuTarjetasConLaInformacion(informacionPago)
        );
    }

    @Entonces("^debe visualizar que el pago de tarjeta propia fue exitoso y se le desconto el valor correcto de su cuenta$")
    public void debeVisualizarQueElPagoDeTarjetaFueExitosoYSeLeDescontoElValorCorrectoDeSuCuenta(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("La tarjeta de crédito se pagó exitosamente"),
                ValidarTicketPagoTarjetaPropia.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionPago)
        );
    }

    @Cuando("^realiza el pago de tarjeta propia desde la cuenta propia con bitcoins$")
    public void realizaElPagoDeTarjetaDesdeLaCuentaPropiaTercerosConBitcoins(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoTarjetaPropia.conBitcoindDesdeMenuCuentasConLaInformacion(informacionPago)
        );
    }

}
