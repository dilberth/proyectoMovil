package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDiferidosTDC;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaDiferidosTDCStepDefinition {
    @Entonces("^valida que se muestre la tabla y registros de diferidos de tarjeta de crédito$")
    public void validaQueSeMuestreLaTablaYRegistrosDeDiferidosDeTarjetaDeCrédito(List<Cuentas> tarjeta) {
        theActorInTheSpotlight().attemptsTo(ValidacionDiferidosTDC.para(tarjeta));
    }
}