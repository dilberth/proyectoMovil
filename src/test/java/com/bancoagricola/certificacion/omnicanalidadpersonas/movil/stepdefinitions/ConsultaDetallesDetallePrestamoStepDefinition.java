package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetallePrestamo;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetallesDetallePrestamoStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos de Préstamo$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDePréstamo(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionDetallePrestamo.con(datos));
    }
}