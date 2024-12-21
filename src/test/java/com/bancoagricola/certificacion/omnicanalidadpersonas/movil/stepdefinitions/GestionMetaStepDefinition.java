package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.*;

import java.util.*;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class GestionMetaStepDefinition {

    @Cuando("^valida que no se encuentre creada la meta$")
    public void validaQueNoSeEncuentreCreadaLaMeta(List<Ahorros> meta) {
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarMeta.con(meta));
    }

    @Cuando("^completa el proceso para crear meta y valida el ticket$")
    public void completaElProcesoParaCrearMetaYValidaElTicket(List<Ahorros> meta) {
        theActorInTheSpotlight().attemptsTo(
                ValidadorEliminarMeta.con(meta),
                CreacionMeta.para(meta),
                ValidacionTicketCreacionMeta.elementos(meta));
    }

    @Cuando("^completa el proceso para crear meta$")
    public void completaElProcesoParaCrearMeta(List<Ahorros> meta) {
        theActorInTheSpotlight().attemptsTo(
                VolverInicio.click(),
                ValidadorEliminarMeta.con(meta),
                CreacionMeta.para(meta));
    }

    @Cuando("^realiza el proceso de modificación de la meta y valida el ticket$")
    public void realizaElProcesoDeModificaciónDeLaMetaYValidaElTicket(List<Ahorros> meta) {
        theActorInTheSpotlight().attemptsTo(
                ModificacionMeta.para(meta),
                ValidacionTicketModificacionMeta.elementos());
    }

    @Entonces("^realiza el proceso de eliminacion de la meta y valida el ticket$")
    public void realizaElProcesoDeEliminacionDeLaMetaYValidaElTicket(List<Ahorros> meta) {
        theActorInTheSpotlight().attemptsTo(
                EliminacionMeta.para(meta),
                ValidacionTicketEliminacionMeta.elementos());
    }

    @Entonces("^realiza el proceso de eliminacion de la meta$")
    public void realizaElProcesoDeEliminacionDeLaMeta(List<Ahorros> meta) {
        theActorInTheSpotlight().attemptsTo(
                VolverInicio.click(),
                ValidadorEliminarMeta.con(meta));
    }

    @Cuando("^realiza el proceso de aporte y retiro a la meta validando los movimientos y el ticket$")
    public void realizaElProcesoDeAporteYRetiroALaMetaValidandoLosMovimientosYElTicket(List<Ahorros> meta) {
        theActorInTheSpotlight().attemptsTo(
                VolverInicio.click(),
                AportarMeta.para(meta),
                ValidacionTicketAporteMeta.elementos(),
                ValidacionMovimientoMetaAporte.para(meta),
                RetiroMeta.para(meta),
                ValidacionTicketRetiroMeta.elementos(),
                ValidacionMovimientoMetaRetiro.para(meta));
    }
}