package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.NotificacionesDeViajeros;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.NotificacionViajeros1Tarjeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.NotificacionViajerosTodasTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionTicketNotificacionViajeros;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class NotificacionDeViajerosStepDefinition {

    @Dado("^crea la gestion para notificación de viajeros para una tarjeta$")
    public void creaLaGestionParaNotificaciónDeViajerosParaUnaTarjeta(List<NotificacionesDeViajeros> opcion) {
        theActorInTheSpotlight().attemptsTo(
                NotificacionViajeros1Tarjeta.para(opcion));
    }

    @Entonces("^valida que se muestre mensaje de confirmación de creación de gestión y valida el ticket$")
    public void validaQueSeMuestreMensajeDeConfirmaciónDeCreaciónDeGestiónYValidaElTicket() {
        theActorInTheSpotlight().attemptsTo(
                ValidacionTicketNotificacionViajeros.elementos());
    }

    @Dado("^crea la gestion para notificación de viajeros para todas las tarjetas$")
    public void creaLaGestionParaNotificaciónDeViajerosParaTodasLasTarjetas(List<NotificacionesDeViajeros> opcion) {
        theActorInTheSpotlight().attemptsTo(
                NotificacionViajerosTodasTarjetas.para(opcion)
        );
    }

}