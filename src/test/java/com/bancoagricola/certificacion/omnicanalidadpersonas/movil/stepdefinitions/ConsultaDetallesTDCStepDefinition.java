package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Tarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetalleTDC;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetallesTDCStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos de la tarjeta de crédito$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDeLaTarjetaDeCrédito(List<Tarjetas> tarjeta) {
        theActorInTheSpotlight().attemptsTo(ValidacionDetalleTDC.para(tarjeta));
    }
}