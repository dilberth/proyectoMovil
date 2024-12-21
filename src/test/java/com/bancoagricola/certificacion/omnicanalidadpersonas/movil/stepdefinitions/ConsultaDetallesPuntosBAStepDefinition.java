package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Tarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetallePuntosBA;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetallesPuntosBAStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos de Puntos BA$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDePuntosBA(List<Tarjetas> datos2) {
        theActorInTheSpotlight().attemptsTo(ValidacionDetallePuntosBA.para(datos2));
    }
}