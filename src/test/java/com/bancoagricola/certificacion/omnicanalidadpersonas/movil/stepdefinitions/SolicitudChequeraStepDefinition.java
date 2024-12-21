package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarTicketSolicitudDeChequera;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoDeSolicitudDeChequera;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoLogueo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Usuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class SolicitudChequeraStepDefinition {

    @Cuando("^realiza proceso para solicitud de chequeras$")
    public void realizaProcesoParaSolicitudDeChequeras(List<Transferencias> informacionSolicitudChequera) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                //ProcesoLogueo.con(Usuario.PRIVADO01),
                ProcesoDeSolicitudDeChequera.conLaInformacion(informacionSolicitudChequera));
    }

    @Entonces("^el sistema me informa que la solicitud de creacion de chequera fue exitosa$")
    public void elSistemaMeInformaQueLaSolicitudDeCreacionDeChequeraFueExitosa() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("Solicitud de chequeras - Resultado"),
                ValidarTicketSolicitudDeChequera.enPantalla());
    }
}