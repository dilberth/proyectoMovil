package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetalleADS;
import cucumber.api.java.es.Entonces;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDetallesADSStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los datos de Adelanto de salario$")
    public void validaQueSeMuestrenDeFormaCorrectaLosDatosDeAdelantoDeSalario(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionDetalleADS.con(datos));
    }
}