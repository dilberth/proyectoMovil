package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.es.*;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ConsultaDetalleMetaStepDefinition {

    @Cuando("^valida el detalle para la meta$")
    public void validaElDetalleParaLaMeta(List<Ahorros> meta) {
        theActorInTheSpotlight().attemptsTo(
                //VolverInicio.click(),
                ValidacionDetalleMeta.con(meta)
        );
    }
}