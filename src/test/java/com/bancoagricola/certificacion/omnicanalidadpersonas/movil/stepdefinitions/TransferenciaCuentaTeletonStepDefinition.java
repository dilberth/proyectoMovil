package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoTransferenciaCtaTeleton;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionDetalleCuentaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ValidacionTicketTeleton;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaCuentaTeletonStepDefinition {

    @Cuando("^realiza la transferencia desde su cuenta a una cuenta teleton$")
    public void realizaLaTransferenciaDesdeSuCuentaAUnaCuentaTeleton(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaCtaTeleton.para(datos),
                ValidacionTicketTeleton.elementos());
    }
}