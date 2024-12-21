package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VolverInicio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarQueElUltimoMovimientoCuenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarTicketPagoPrestamoPropio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoPagoPrestamoPropio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidaSaldosOrigenDespues;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class PagoPrestamoPropioStepDefinition {

    @Cuando("^realiza el pago de prestamo desde la cuenta propia$")
    public void realizaElPagoDePrestamoDesdeLaCuentaPropia(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoPrestamoPropio.desdeCuentaConLaInformacion(informacionPago));
    }

    @Cuando("^realiza el pago de prestamo desde el menu de cuentas$")
    public void realizaElPagoDePrestamoDesdeElMenuDeCuentas(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoPrestamoPropio.desdeMenuCuentasConLaInformacion(informacionPago));
    }

    @Cuando("^realiza el pago de prestamo desde la cuenta propia con bitcoins$")
    public void realizaElPagoDePrestamoDesdeLaCuentaPropiaConBitcoins(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoPrestamoPropio.conBitcoindDesdeMenuCuentasConLaInformacion(informacionPago));
    }

    @Entonces("^debe visualizar que el pago de prestamo fue exitoso y se le desconto el valor correcto de su cuenta$")
    public void debeVisualizarQueElPagoDePrestamoFueExitosoYSeLeDescontoElValorCorrectoDeSuCuenta(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("El préstamo se pagó exitosamente"),
                ValidarTicketPagoPrestamoPropio.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionPago));
    }

    @Entonces("^se debe visualizar el QR de pago con bitcoins$")
    public void seDebeVisualizarElQRDePagoConBitcoins() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("Pagar con Bitcoin",60),
                Esperar.texto("Monto del pago"),
                Esperar.texto("QR de pago")
        );

    }




}