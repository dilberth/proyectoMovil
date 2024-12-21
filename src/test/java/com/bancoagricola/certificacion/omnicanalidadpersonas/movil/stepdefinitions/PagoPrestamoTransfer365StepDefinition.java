package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarTicketPagoPrestamoTransfer365;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoPagoDePrestamoTransfer365;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidaSaldosOrigenDespues;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class PagoPrestamoTransfer365StepDefinition {

    @Cuando("^realizar el pago de prestamo a otro banco usando Transfer 365 ingresando los datos$")
    public void realizarElPagoDePrestamoAOtroBancoUsandoTransferIngresandoLosDatos(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoDePrestamoTransfer365.conLaInformacion(informacionPago)
        );

    }

    @Cuando("^realizar el pago de prestamo a otro banco usando Transfer 365 de un prestramo guardado como favorito$")
    public void realizarElPagoDePrestamoAOtroBancoUsandoTransferDeUnPrestramoGuardadoComoFavorito(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoDePrestamoTransfer365.conLaInformacion(informacionPago)
        );
    }

    @Entonces("^debe visualizar que el pago transfer 365 fue exitoso y se realiza el debito del valor pagado a la cuenta$")
    public static void PagoPrestamoTransfer365StepDefinition(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidarTicketPagoPrestamoTransfer365.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionPago)
        );
    }


}
