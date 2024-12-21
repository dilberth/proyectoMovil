package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Ahorros;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetalleAhorroProgramado;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetalleAhorroProgramadoStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos del Ahorro Programado$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDelAhorroProgramado(List<Ahorros> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionDetalleAhorroProgramado.con(datos));
    }
}