package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetalleCuentaAhorro;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetalleCuentaAhorroStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos de la cuenta de ahorro$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDeLaCuentaDeAhorro(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionDetalleCuentaAhorro.con(datos));
    }
}