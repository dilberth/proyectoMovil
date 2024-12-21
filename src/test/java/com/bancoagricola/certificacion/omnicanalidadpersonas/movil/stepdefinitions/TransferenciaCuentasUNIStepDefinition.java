package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.ast.*;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class TransferenciaCuentasUNIStepDefinition {

    @Cuando("^realiza la transferencia UNI$")
    public void realizaLaTransferenciaUNI(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaUNI.para(datos));
    }

}