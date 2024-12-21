package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetalleCuentaCorriente;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetalleCuentaCorrienteStepDefinition {
    @Entonces("^valida que se muestren de forma correcta los datos de la cuenta corriente$")

    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDeLaCuentaCorriente(List<Cuentas> datos) {
theActorInTheSpotlight().attemptsTo(
        ValidacionDetalleCuentaCorriente.con(datos));
    }
}