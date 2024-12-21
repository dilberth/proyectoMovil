package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetalleExtrafinanciamiento;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetallesDetalleExtrafinanciamientoStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos de Extrafinanciamiento$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDeExtrafinanciamiento(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionDetalleExtrafinanciamiento.con(datos));
    }
}