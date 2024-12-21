package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.AmbienteDePruebas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Cerrar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.EstadoLogin;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Assume;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTACTOR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTBIENVENIDO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ActorStepDefinition {

    @Before(value = "@manual" ,order = 0)
    public void skipDev(Scenario scenario){
        System.out.println("DEVELOPING SCENARIO is : "+ scenario.getName());
        Assume.assumeTrue(false);
    }

    @Before(value = "@DEV" ,order = 1)
    public void setAmbiente(Scenario scenario){
        AmbienteDePruebas.setAmbienteQA(false);
    }

    @Before(order = 2)
    public void cliente() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(TXTACTOR);
        TargetApp.paraSO(((AppiumDriver) ThucydidesWebDriverSupport.getProxiedDriver()).getCapabilities().getCapability("platformName").toString());
        ((AppiumDriver)ThucydidesWebDriverSupport.getProxiedDriver()).hideKeyboard();
    }

    @After
    public void finalizacionAutomatizacion() {
        EstadoLogin.setEstadoLogin(true);
        if ("ios".equals(TargetApp.getSoAuto())) {
            Cerrar.app();
        }
    }

}