package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VolverInicio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarTicketPagoPrestamoUni;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoPagoPrestamoUni;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidaSaldosOrigenDespues;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class PagoPrestamosUniStepDefinition {

    @Cuando("^realiza el pago de prestamo UNI$")
    public void realizaElPagoDePrestamoUni(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoPrestamoUni.conLaInformacion(informacionPago)
        );
    }

    @Cuando("^realiza el pago de prestamo UNI desde favorito$")
    public void realizaElPagoDePrestamoUniDesdeFavorito(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoPrestamoUni.conLaInformacion(informacionPago)
        );
    }

    @Entonces("^debe visualizar que el pago de prestamo entre bancos UNI fue exitoso y se le desconto el valor correcto de su cuenta$")
    public void debeVisualizarQueElPagoDePrestamoEntreBancosUniFueExitosoYSeLeDescontoElValorCorrectoDeSuCuenta(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("Pago de Préstamo UNI: Operaciones entre bancos pendiente de aplicación"),
                ValidarTicketPagoPrestamoUni.enPantalla()
        );

        Utilidades.esperar(2);

        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidaSaldosOrigenDespues.para(informacionPago)
        );
    }

}
