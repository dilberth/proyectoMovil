package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoConsultaCVV2;
import cucumber.api.java.es.Dado;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsutaFEyCVV2ECardStepDefinition {

    @Dado("^realiza validación de  datos de e-card$")
    public void realizaValidaciónDeDatosDeECard(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(ProcesoConsultaCVV2.para(datos));
    }
}