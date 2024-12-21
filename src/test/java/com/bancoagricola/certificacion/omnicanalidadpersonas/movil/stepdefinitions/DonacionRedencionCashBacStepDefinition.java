package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actions.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class DonacionRedencionCashBacStepDefinition {

    @Cuando("^valida saldo de puntos BA antes de realizar la transacción$")
    public void validaSaldoDePuntosBAAntesDeRealizarLaTransacción(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaPuntosBAAntes.para(datos));
    }

    @Cuando("^realiza el proceso de donacion para una ONG$")
    public void realizaElProcesoDeDonacionParaUnaONG(List<Tarjetas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoDonacionCashBac.para(datos),
                ValidacionTicketDonacionCashBac.elementos()
        );
    }

    @Cuando("^valida saldo de puntos BA previo a realizar la transacción$")
    public void validaSaldoDePuntosBAPrevioARealizarLaTransacción(List<Cuentas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ValidaPuntosBAAntes.para(datos));
    }

    @Cuando("^realiza el proceso de transferencia de cashbac a una cuenta propia$")
    public void realizaElProcesoDeTransferenciaDeCashbacAUnaCuentaPropia(List<Tarjetas> datos) {
        theActorInTheSpotlight().attemptsTo(
                ProcesoRedencionCashBac.para(datos),
                ValidacionTicketRedencionCashBac.elementos());
    }
}