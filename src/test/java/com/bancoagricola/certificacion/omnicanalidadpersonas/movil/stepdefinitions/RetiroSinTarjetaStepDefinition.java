package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoRetiroSinTarjeta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionTicketRetiroSinTarjeta;
import cucumber.api.java.es.Dado;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RetiroSinTarjetaStepDefinition {

    @Dado("^realiza el proceso para generacion de codigo validando el ticket generado$")
    public void realizaElProcesoParaGeneracionDeCodigoValidandoElTicketGenerado(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoRetiroSinTarjeta.para(datos),
                ValidacionTicketRetiroSinTarjeta.de(datos));
    }
}