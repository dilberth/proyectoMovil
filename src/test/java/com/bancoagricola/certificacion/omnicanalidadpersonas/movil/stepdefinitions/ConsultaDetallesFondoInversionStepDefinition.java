package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetalleFondoInversion;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetallesFondoInversionStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos de Fondo de inversión$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDeFondoDeInversión(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(ValidacionDetalleFondoInversion.con(datos));
    }
}