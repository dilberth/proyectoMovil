package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VolverInicio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarQueElUltimoMovimientoCuenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarTicketPagoServiciosNpe;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Usuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class PagoServiciosNpeStepDefinition {

    @Dado("que se el valor de los saldos del usuario (.*) de la tarjeta de credito$")
    public void queSeElValorDeLosSaldosDelUsuarioDeLaTarjetaDeCredito(Usuario usuario, List<Cuentas> informacionTarjeta) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(usuario),
                ValidaSaldosTarjetaCreditoAntes.para(informacionTarjeta),
                VolverInicio.click()
        );
    }

    @Cuando("^realiza el proceso de pago de servicio con NPE desde cuenta de ahorro$")
    public void realizaElProcesoDePagoDeServicioConNpeDesdeCuentaDeAhorro(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoServiciosNpe.desdeMenuDeCuentasConLaInformacion(informacionPago));
    }

    @Cuando("^realiza el proceso de pago de servicio con NPE desde tarjeta de crédito$")
    public void realizaElProcesoDePagoDeServicioConNpeDesdeTarjetaDeCredito(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoServiciosNpe.desdeMenuDeTarjetasConLaInformacion(informacionPago));
    }

    @Entonces("^debe visualizar que el pago de servicios npe fue exitoso y se le desconto el valor correcto de su cuenta$")
    public void debeVisualizarQueElPagoDeServiciosNpeFueExitosoYSeLeDescontoElValorCorrectoDeSuCuenta(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("El servicio se pagó exitosamente"),
                ValidarTicketPagoServiciosNpe.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionPago)
        );
    }

    @Entonces("^debe visualizar que el pago de servicios npe fue exitoso y se le desconto el valor correcto de su tarjeta$")
    public void debeVisualizarQueElPagoDeServiciosNpeFueExitosoYSeLeDescontoElValorCorrectoDeSuTarjeta(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("El servicio se pagó exitosamente"),
                ValidarTicketPagoServiciosNpe.enPantalla(),
                ValidaSaldosTarjetaCreditoDespues.para(informacionPago)
        );
    }
}