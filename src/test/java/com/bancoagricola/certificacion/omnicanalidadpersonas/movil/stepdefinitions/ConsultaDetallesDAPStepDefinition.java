package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetalleDAP;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetallesDAPStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos de Deposito a plazo$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDeDepositoAPlazo(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionDetalleDAP.con(datos));
    }
}