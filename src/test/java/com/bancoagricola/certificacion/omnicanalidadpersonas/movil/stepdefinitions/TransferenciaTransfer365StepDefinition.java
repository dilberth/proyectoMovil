package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.ast.Cuando;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class TransferenciaTransfer365StepDefinition {

    @Cuando("^realiza la transferencia Transfer 365$")
    public void realizaLaTransferenciaTransfer(List<Transferencias> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransfer365.para(datos),
                ValidacionTicketTransfer365.elementos(datos));
    }

}