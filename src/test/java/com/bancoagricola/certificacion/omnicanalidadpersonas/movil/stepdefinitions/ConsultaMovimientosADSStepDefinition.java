package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.es.*;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ConsultaMovimientosADSStepDefinition {

    @Cuando("^realiza traslado de saldo de la cuenta origen a cuenta de tercero$")
    public void realizaTrasladoDeSaldoDeLaCuentaOrigenACuentaDeTercero(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaTerceroCuentaNueva.para(datos));
    }

    @Cuando("^realiza transferencia a cuenta de terceros$")
    public void realizaTrasferenciaACuentaDeTerceros(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoTransferenciaTerceroCuentaNueva2.para(datos));
    }

    @Entonces("^valida los movimientos del producto para el periodo seleccionado$")
    public void validaLosMovimientosDelProductoParaElPeriodoSeleccionado(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionMovimientoCuentas.para(datos));
    }

    @Entonces("^valida los movimientos del producto para fecha especifica$")
    public void validaLosMovimientosDelProductoParaFechaEspecifica(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidacionMovimientoFecha.para(datos));
    }
}