package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.es.Dado;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RecargaPaquetesStepDefinition {

    @Dado("^realiza proceso de recarga de celular$")
    public void realizaProcesoDeRecargaDeCelular(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoRecargaCelular.para(datos),
                ValidacionTicketRecargas.elementos(datos));
    }
}