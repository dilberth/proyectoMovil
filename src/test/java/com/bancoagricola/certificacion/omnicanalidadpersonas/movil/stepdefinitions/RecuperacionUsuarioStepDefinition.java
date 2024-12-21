package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.EsVisible;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoRecuperacionDeUsuario;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class RecuperacionUsuarioStepDefinition {
    @Cuando("^ingresa a recuperar usuario e ingresa los datos de identificacion$")
    public void ingresaARecuperarUsuarioEIngresaLosDatosDeIdentificacion(List<String> informacionDocumento) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoRecuperacionDeUsuario.conLaInformacion(informacionDocumento));
    }

    @Entonces("^se visualiza el resultado de \"(.*)\"")
    public void seVisualizaElResultadoDe(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(EsVisible.elElemento(UiGenerico.elementoDeTexto(mensajeEsperado)), equalTo(true)).because("El mensaje ' " + mensajeEsperado + " ' es visible en pantalla"));
    }
}