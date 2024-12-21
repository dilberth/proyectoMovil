package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.es.*;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ConsultaMovimientosAhorroProgramadoStepDefinition {

    @Dado("^realiza el proceso de transferencia desde ahorro programado$")
    public void realizaElProcesoDeTransferenciaDesdeAhorroProgramado(List<Ahorros> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaAPaCP_AP.para(datos));
    }

    @Entonces("^valida los movimientos del ahorro programado para el periodo seleccionado$")
    public void validaLosMovimientosDelAhorroProgramadoParaElPeriodoSeleccionado(List<Ahorros> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionMovimientoAhorros.para(datos));
    }

    @Entonces("^valida los movimientos de la cuenta de ahorro programado para una fecha especifica$")
    public void validaLosMovimientosDeLaCuentaDeAhorroProgramadoParaUnaFechaEspecifica(List<Ahorros> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionMovimientoFechaAhorros.para(datos));
    }

}